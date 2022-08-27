package com.zerobase.fastlms.history.mapper;

import com.zerobase.fastlms.history.entity.LoginHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper {

    List<LoginHistory> selectList(String userId);
}
