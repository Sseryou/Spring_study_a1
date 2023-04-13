package models.member;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Member {

    private Long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String mobile;
    private String email;
    private LocalDateTime regDt;
}
