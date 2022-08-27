package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.model.BannerParam;
import com.zerobase.fastlms.comfiguration.model.CategoryInput;

import java.util.List;

public interface BannerService {


    List<BannerDto> list(BannerParam parameter);
}
