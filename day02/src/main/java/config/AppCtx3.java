package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.time.format.DateTimeFormatter;

@Configuration

/*@ComponentScan(basePackages = "models.member",
excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes={ManualBean.class}))
//적용할 클래스 범위를 필터로 설정했다. 현재 설정은 'ManualBean''애노테이션'이 달린 '클래스'를 스캔 범위에서 '제외'한다.*/
/*@ComponentScan(basePackages = "models.member",
excludeFilters = {
        @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, classes = {MemberDao.class}),
        @ComponentScan.Filter(type=FilterType.ASPECTJ, pattern = "models.member.**Service")
})
//클래스 명을 기준으로 제외한다. type=FilterType.ASSIGNABLE_TYPE는 필터의 타입을 클래스명으로 결정해준다.
//ANT 패턴으로 제거한다. models.member 클래스 내부 모든 클래스 중 Service로 끝나는 것들을 제외한다.*/
//models.member 패키지를 포함한 모든 하위 경로가 범위로 설정됨
//ComponentScan을 사용하기 위해, 하위 모든 경로에 애노테이션을 붙여 주었다. @Service 등...

@ComponentScan("models.member")
public class AppCtx3 {

    //외부 라이브러리, 기본적인 class 등은 건드리지 못하기 때문에,
    //@Bean 으로 따로 여기서 만들어 주어서 사용해야 한다.
    @Bean
    public DateTimeFormatter dateTimeFormatter(){
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
      return formatter;
    }

}
