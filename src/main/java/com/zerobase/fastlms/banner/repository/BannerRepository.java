package com.zerobase.fastlms.banner.repository;

import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BannerRepository extends JpaRepository<Banner, Long> {


    /**
     * 사용중인 배너 내림차순으로 목록 가져오기
     * @return
     */
    Optional<List<Banner>> findAllByUsingYnIsTrueOrderBySortValueDesc();



}
