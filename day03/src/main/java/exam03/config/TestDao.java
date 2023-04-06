package exam03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDao {
    //테스트하기 위해서 추가

    //@Autowired로 의존성을 받아온다.
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //sql 명령문을 이용하여 데이터베이스에 반영
    //실험하고 싶으면 DEPT_EX를 미리 만들어 둘 것.
    public void insert() {
        String sql = "INSERT INTO DEPT_EX VALUES (?, ?, ?)";
        int cnt = jdbcTemplate.update(sql, 10, "부서명", "인천");
    }
}
