package models.member;

import lombok.Data;

import java.time.LocalDateTime;

@Data //lombok 기능. getter, setter 등 자동설정하는 애노테이션
public class Member {

    private long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private LocalDateTime regDt;


}
