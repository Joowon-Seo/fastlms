package com.zerobase.fastlms.banner.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BannerInput {

    Long id;

    String bannerName;
    String urlPath;         // 클릭시 이동하는 곳
    String howOpen;
    int sortValue;          // 정렬 순서
    boolean usingYn;        // 공개 여부

    //삭제를 위한
    String idList;

    String filename;
    String urlFilename;     // 파일 저장되는 곳

}
