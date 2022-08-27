package com.zerobase.fastlms.history.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    private String userId;
    private LocalDateTime loginDt;
    private String ip;
    private String userAgent;

    private long totalCount;
    private long seq;

    public String getloginDtText(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return loginDt != null ? loginDt.format(formatter) : "";
    }

}


