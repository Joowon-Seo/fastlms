package com.zerobase.fastlms.history.repository;

import com.zerobase.fastlms.history.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {


}

