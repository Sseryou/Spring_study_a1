package models.member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private String userId;
    private String userNm;
    private String mobile;
    private LocalDateTime regDt;
}
