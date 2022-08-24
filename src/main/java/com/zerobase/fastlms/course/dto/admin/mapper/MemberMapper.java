package com.zerobase.fastlms.course.dto.admin.mapper;

import com.zerobase.fastlms.course.dto.admin.dto.MemberDto;
import com.zerobase.fastlms.comfiguration.model.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    long selectListCount(MemberParam parameter);
    List<MemberDto> selectList(MemberParam parameter);
}
