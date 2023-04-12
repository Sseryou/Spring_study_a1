package controllers.members;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Login {

    @NotBlank
    private String userId;
    @NotBlank
    private String userPw;


    private boolean saveId;

}
