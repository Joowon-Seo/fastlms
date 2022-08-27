package com.zerobase.fastlms.history.service;

import com.zerobase.fastlms.history.entity.LoginHistory;
import com.zerobase.fastlms.history.repository.LoginHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HistoryServiceImpl implements HistoryService {

    private final LoginHistoryRepository loginHistoryRepository;


    @Override
    public List<LoginHistory> getList(String userId) {

        long totalCount = loginHistoryRepository.countAllByUserId(userId);

        List<LoginHistory> list = loginHistoryRepository.findAllByUserId(userId);
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (LoginHistory x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - i);
                i++;
            }
        }

        return loginHistoryRepository.findAllByUserId(userId);
    }

    @Override
    public Long getCount(String userId) {

        return loginHistoryRepository.countAllByUserId(userId);
    }
}
