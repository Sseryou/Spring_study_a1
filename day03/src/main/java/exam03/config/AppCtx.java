package exam03.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppCtx {
    //org.apache.tomcat으로 임포트
    @Bean
    public DataSource dataSource(){ //127.0.0.1
        //thin 뒤에는 회사 도메인 같은것을 붙여야 한다.
        //thin 뒤 1521, 데이터베이스명 orcl

        DataSource ds = new DataSource();
        //db를 연결해야 한다.
        //External Libraries 확인
        //데이터베이스 연결 설정
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl(url);
        ds.setUsername("scott");
        ds.setPassword("tiger");
        //커넥션 풀 설정
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        //최대 커넥션 풀과 최소 커넥션 풀을 설정

        ds.setTestWhileIdle(true); //연결 유휴 상태일때 체크
        ds.setTimeBetweenEvictionRunsMillis(3000); //3초마다 유휴 객체 연결 확인
        ds.setMinEvictableIdleTimeMillis(60000);//60초 이후 연결 객체 다시 생성



        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //위에서 만든 데이터소스 주입
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public TestDao testDao(){
        return new TestDao();
    }


}
