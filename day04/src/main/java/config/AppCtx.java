package config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration //스프링 설정 클래스임을 의미한다.
@ComponentScan("models") //models패키지 하위의 파일을 전부 범위 안에 설정
//@Component 애노테이션을 붙인 클래스를 스캔해서 스프링 빈으로 등록할 수 있게 해준다.
public class AppCtx {


    @Bean(destroyMethod = "close")
    //스프링 컨테이너 소멸 시
    //자동으로 자원 해제를 하도록 설정
    //메서드 이름 DataSource는 고정이다.(이미 정의되어 있음)
    public DataSource dataSource(){
        DataSource ds = new DataSource();


        //정의되어 있다.
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");

        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");

        ds.setUsername("springdb");

        ds.setPassword("aA123456");

        //커넥션 풀
        //실제 서버가 아니기 때문에 아주 조금 설정한 상태
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        //체크하도록 설정
        ds.setTestWhileIdle(true);
        //체크 주기 3초
        ds.setTimeBetweenEvictionRunsMillis(3000);
        //갱신주기 1분
        ds.setMinEvictableIdleTimeMillis(60000);



        return ds;
    }
    //클래스 이름 JdbcTemplate은 고정이다.(이미 정의되어 있음)
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }


    @Bean
    //트랜잭션을 자동으로 관리하는 메서드
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());
        return tm;
    }


}
