package exam02;


import models.member.JoinService;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public JoinService joinService(){
        JoinService joinService = new JoinService(memberDao());

        return joinService;
    }


}
