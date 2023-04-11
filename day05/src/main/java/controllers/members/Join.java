package controllers.members;

import lombok.Data;

@Data
public class Join {
    private String userId;
    private String userPw;
    private String userPwRe;

    private String userNm;

    private boolean agree;
}
