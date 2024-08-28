package com.damoim.model.vo;



import java.util.Date;

import com.damoim.model.dto.MembershipDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Membership {
    private int membershipCode; // 클럽코드
    private String membershipName; // 클럽이름
    private String membershipImg; // 클럽메인사진
    private String membershipInfo; // 클럽소개
    private Date membershipDate; // 클럽생성날짜
    private double membershipGrade; // 클럽 별점
    private int membershipMax; // 클럽최대인원
}


