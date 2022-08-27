package com.zerobase.fastlms.history.service;

import com.zerobase.fastlms.history.entity.LoginHistory;

import java.util.List;

public interface HistoryService {

    List<LoginHistory> getList(String userId);

    Long getCount(String userId);
}
