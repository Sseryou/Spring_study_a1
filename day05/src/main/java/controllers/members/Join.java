package controllers.members;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Join {
    // null이 아니고 최소한 1개이상의 공백아닌 문자가 있는지 검사
    @NotBlank
    @Size(min=6, max=16)
    private String userId;

    @NotBlank
    @Size(min=8)
    private String userPw;

    @NotBlank
    private String userPwRe;

    @NotBlank
    private String userNm;

    @Email
    private String email;

    @AssertTrue //true인지 검사
    private boolean agree;

}
