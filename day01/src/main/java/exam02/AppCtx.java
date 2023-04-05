package exam02;


import models.member.JoinService;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링 프레임워크를 사용하겠다는 애노테이션
public class AppCtx {

    //이 클래스는 Spring으로 인해 관리받는 상태이다.


    //return new 부분을 교체하여, 수정 사항이 반영된 새로운 클래스를
    //이 객체의 이름을 변경하지 않고도 반영할수 있게 한 의존성 관리의 형태이다.
    //이 memberDao는 반환형이 MemberDao 클래스이다.
    @Bean //해당 메서드가 생성한 객체는 스프링이 관리하게 된다.
    public MemberDao memberDao(){
        return new MemberDao();
    }


    //위에서의 memberDao를 받아, 가입을 관리하는 메서드로 바꾼 형태이다.
    //이것은 memberDao의 정보가 내장되어있는, JoinService형태의 joinService를 반환한다.
    //memberDao()의 객체정보(현재 memberDao 클래스)를 담은 동일한 이름의 객체를 내보낸다.
    //이것은 memberDao()의 정보만 수정해도, joinService에 반영이 된다는 것을 의미한다.
    @Bean
    public JoinService joinService(){
        JoinService joinService = new JoinService(memberDao());

        return joinService;
    }


}
