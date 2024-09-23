package com.damoim.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MeetingsAgree {
    private int meetAgreeCode; // 참여여부 코드
    private boolean meetAgreeYn; // 참여 여부
  //  private int listCode; // 클럽멤버 코드
    private String id;
    private List<String> ides;
    private int meetCode;
    
    private Member member;
}

