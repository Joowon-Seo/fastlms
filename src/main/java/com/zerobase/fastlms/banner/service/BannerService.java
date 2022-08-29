package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.model.BannerInput;
import com.zerobase.fastlms.banner.model.BannerParam;
import com.zerobase.fastlms.comfiguration.model.CategoryInput;

import java.util.List;

public interface BannerService {


    /**
     * 배너 목록
     */
    List<BannerDto> list(BannerParam parameter);

    /**
     * 배너 상세정보
     * @param id
     * @return
     */
    BannerDto getById(long id);

    /**
     * 배너 추가
     */
    boolean add(BannerInput parameter);

    /**
     * 배너 변경
     */
    boolean set(BannerInput parameter);

    /**
     * 배너 내용 삭제
     */
    boolean del(String idList);

    List<BannerDto> frontList();
}
