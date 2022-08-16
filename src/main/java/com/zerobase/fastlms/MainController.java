package com.zerobase.fastlms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){

        return "index"; // return 되는 문자열은 파일명이라고 약속함
    }

    // 아래 과정이 번거롭기 때문에
    // Spring MVC 에서의 view 이용, view -> 템플릿엔진 화면에 내용을 출력

    // view -> HTML : 웹 페이지
    // view -> json : API
    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        String msg = "<html>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "</head>" +
                "<body>" +
                "<p>hello<p/>" +
                "<p>fastlms website!!!</p>" +
                "<p> 안녕하세요!!!! </p>" +
                "</body>" +
                "</html>";

        printWriter.write(msg);
        printWriter.close();
    }


}
