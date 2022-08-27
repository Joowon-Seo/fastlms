package com.zerobase.fastlms.history.repository;

import com.zerobase.fastlms.course.entity.Course;
import com.zerobase.fastlms.history.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {


    /**
     * 회원 아이디에 대해서 로그인 기록을 가져오는 기능
     */
    List<LoginHistory> findAllByUserId(String userId);

    /**
     * 해당 아이디에 대한 기록의 개수를 가져오는 기능
     */
    long countAllByUserId(String userId);


}

