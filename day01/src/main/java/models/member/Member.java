package models.member;

import lombok.Data;

@Data
public class Member {
    //Member에 필요한 정보를 만들때 쓰는 객체이다.
    //lombok의 @Data를 사용해서 @Getter @Setter등을 기본으로 내장하여,
    //getter, setter등의 만들어야 하는 메서드를 생략하고도 만들수 있게 해준다.

    private String userId;
    private String userPw;
    private String userNm;
}
