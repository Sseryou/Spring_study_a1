package controllers.members;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

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

    //날짜 데이터가 문자열이기 때문에 그대로 넘어오면 오류 발생.
    //형식 명시로 값 주입
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private LocalDate birthDt;

    @AssertTrue //true인지 검사
    private boolean agree;

}
