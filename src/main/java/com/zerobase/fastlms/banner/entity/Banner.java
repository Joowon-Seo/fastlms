package com.zerobase.fastlms.banner.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String bannerName;
    String imagePath;
    String urlPath;         // 클릭시 이동하는 곳
    String howOpen;         // 여는 방법(새 창 이동, 현재 창 이동)
    int sortValue;          // 정렬 순서
    boolean usingYn;        // 사용 여부

    String filename;
    String urlFilename;

    LocalDateTime regDt;    //등록일(추가날짜)


}
