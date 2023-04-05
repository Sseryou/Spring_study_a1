package config;

import models.member.InfoService;
import models.member.JoinService;
import models.member.ListService;
import models.member.MemberDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.time.format.DateTimeFormatter;

@Configuration //스프링이 관리할 것임을 의미
@Import({AppCtx2.class}) //설정 클래스를 추가하고, 통합한다.
public class AppCtx {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    //의존성 주입.
    @Bean
    public JoinService joinService(){
        return new JoinService();
    }

    //객체를 만들어 놓고, 필요할 때마다 의존성 주입을 한다.
    //실제로는 이 과정도 필요가 없다.
    @Bean
    public ListService listService(){
        return new ListService();
    }

    //생성자 매개변수로 만들어도 주입됨을 보여줌.
//    @Bean
//    public InfoService infoService(){
//        return new InfoService();
//    }

    //bean이 없으면, nullpointerException이 발생하게 된다.
    @Bean
    public DateTimeFormatter dateTimeFormatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm");
        return formatter;
    }



}
