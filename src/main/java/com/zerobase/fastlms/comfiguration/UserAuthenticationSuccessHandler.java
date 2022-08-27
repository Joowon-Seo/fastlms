package com.zerobase.fastlms.comfiguration;

import com.zerobase.fastlms.history.entity.LoginHistory;
import com.zerobase.fastlms.history.repository.LoginHistoryRepository;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final LoginHistoryRepository loginHistoryRepository;
    private final MemberRepository memberRepository;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request
            , HttpServletResponse response
            , Authentication authentication) throws IOException, ServletException {

        String userId = authentication.getName();
        String userIp = getIp(request);
        String userAgent = request.getHeader("User-Agent");
        LocalDateTime nowTime = LocalDateTime.now();

        LoginHistory loginHistory = LoginHistory.builder()
                .userId(userId)
                .loginDt(nowTime)
                .ip(userIp)
                .userAgent(userAgent)
                .build();

        loginHistoryRepository.save(loginHistory);

        Optional<Member> optionalMember = memberRepository.findById(userId);
        if (!optionalMember.isPresent()){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        Member member = optionalMember.get();

        member.setLastLoginDt(nowTime);
        memberRepository.save(member);

        log.info(userId);
        log.info(userIp);
        log.info(userAgent);

        super.onAuthenticationSuccess(request, response, authentication);
    }



    public String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info(">>>> Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.info(">>>> WL-Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.info(">>>> HTTP_CLIENT_IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.info(">>>> HTTP_X_FORWARDED_FOR : " + ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        log.info(">>>> Result : IP Address : "+ip);

        return ip;

    }


}
