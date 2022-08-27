package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BannerDto {

    Long id;

    String bannerName;
    String imagePath;
    String urlPath;         // 클릭시 이동하는 곳
    int sortValue;          // 정렬 순서
    boolean usingYn;        // 사용 여부
    LocalDateTime regDt;    //등록일(추가날짜)

    String filename;
    String urlFilename;

    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {

        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .imagePath(banner.getImagePath())
                .urlPath(banner.getUrlPath())
                .sortValue(banner.getSortValue())
                .usingYn(banner.isUsingYn())
                .regDt(banner.getRegDt())
                .filename(banner.getFilename())
                .urlFilename(banner.getUrlFilename())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners) {

        if (banners == null) {
            return null;
        }

        List<BannerDto> bannerDtoList = new ArrayList<>();

        for (Banner x : banners) {
            bannerDtoList.add(BannerDto.of(x));
        }
        return bannerDtoList;


    }

    public String getRegDtText(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return regDt != null ? regDt.format(formatter) : "";
    }
}
