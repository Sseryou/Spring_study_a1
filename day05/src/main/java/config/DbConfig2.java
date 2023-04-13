package config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DbConfig2 {
    @Configuration
    @Profile("dev")//환경변수로써 dev를 만듬
    static class DbDevConfig{
        @Bean(destroyMethod = "close")
        public DataSource dataSource(){
            System.out.println("DEV!!");
            //데이터베이스 경로 및 접속 설정
            DataSource ds = new DataSource();
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("springdb");
            ds.setPassword("aA123456");

            //커넥션 풀 설정
            ds.setInitialSize(2);
            ds.setMaxActive(10);
            //유휴상태 체크
            ds.setTestWhileIdle(true);
            ds.setTimeBetweenEvictionRunsMillis(3000);
            ds.setMinEvictableIdleTimeMillis(60000);


            return ds;
        }

        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }

        @Bean
        public PlatformTransactionManager transactionManager(){
            DataSourceTransactionManager tm = new DataSourceTransactionManager();
            tm.setDataSource(dataSource());
            return tm;
        }
    }


    @Configuration
    @Profile("real") //변수에 따라서 다른 클래스가 만들어진다.
    static class DbRealConfig{

        @Bean(destroyMethod = "close")
        public DataSource dataSource(){
            System.out.println("REAL!!");
            //데이터베이스 경로 및 접속 설정
            DataSource ds = new DataSource();
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("springdb");
            ds.setPassword("aA123456");

            //커넥션 풀 설정
            ds.setInitialSize(2);
            ds.setMaxActive(10);
            //유휴상태 체크
            ds.setTestWhileIdle(true);
            ds.setTimeBetweenEvictionRunsMillis(3000);
            ds.setMinEvictableIdleTimeMillis(60000);


            return ds;
        }

        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }

        @Bean
        public PlatformTransactionManager transactionManager(){
            DataSourceTransactionManager tm = new DataSourceTransactionManager();
            tm.setDataSource(dataSource());
            return tm;
        }
    }


}
