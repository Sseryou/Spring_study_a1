package models.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component //스프링으로 검색해서 빈으로 등록하게 할 수 있게 하는 애노테이션.
@Transactional //메서드에 달아도 되고, 클래스에 달아도 된다.
//프록시와 비슷하게, autoCommit(false)설정 등 필요한 설정들을 대신 해준다.
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired //의존성 자동 주입
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 회원 정보 추가
     * @param member
     */
    public long insert(Member member){
        String sql = "INSERT INTO MEMBER(userNo, userId, userPw, userNm) " +
                    " VALUES (SEQ_MEMBER.nextval, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int cnt = jdbcTemplate.update(c -> {
                PreparedStatement pstmt = c.prepareStatement(sql, new String[]{"userNo"});
                //순서는 1,2,3,4,...
                pstmt.setString(1, member.getUserId());
                pstmt.setString(2, member.getUserPw());
                pstmt.setString(3, member.getUserNm());
                return pstmt;
        }, keyHolder);
        Number keyValue = keyHolder.getKey(); //증감번호 - long, int인지 특정할수 없기 때문에 상위 래퍼클래스인 Number 사용
        //keyholder의 값을 가져와서 keyValue에 넣고, userNo에 투입
        long userNo = keyValue.longValue();
        return userNo;
    }

    /**
    public boolean insert(Member member){

        String sql = "INSERT INTO MEMBER (userNo, userId, userPw, userNm) " +
                        //한칸 띄워야 한다.
                        " VALUES (SEQ_MEMBER.nextval, ?, ?, ?)";

        int cnt = jdbcTemplate.update(sql, member.getUserId(), member.getUserPw(), member.getUserNm());
        // cnt - 반영된 레코드 갯수 -> 0개 이상 나오면 성공.

        //true인지 false인지 return.
        return cnt > 0;
    }
     */

    /**
     * 회원정보를 아이디로 조회
     * @param userId
     * @return
     */
    public Member get(String userId){
        try {
            String sql = "SELECT * FROM MEMBER WHERE userId = ?";
            Member member = jdbcTemplate.queryForObject(sql, this::memberMapper, userId);
            return member;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 회원 목록 조회
     *
     * @return
     */
    public List<Member> gets(){
       String sql = "SELECT * FROM MEMBER";
       //RowMapper<T> rowMapper = 인터페이스,
        // Object...args = 추가로 매개변수에 넣은 값을 넣을 때
       List<Member> members = jdbcTemplate.query(sql, this::memberMapper);
       return members;
    }

    private Member memberMapper(ResultSet rs, int i) throws SQLException{

        //데이터 조회 인터페이스
        //쿼리 식별 결과를 매핑..?

        Member member = new Member();
        //이름값 기준으로 USERNO를 찾은다음 그 값을 long 형태로 읽어서,
        //member의 UserNo에 넣어준다.
        //이하 같은 원리
        member.setUserNo(rs.getLong("USERNO"));
        member.setUserId(rs.getString("USERID"));
        member.setUserPw(rs.getString("USERPW"));
        member.setUserNm(rs.getString("USERNM"));
        member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());

        return member;
    }




    /**
     * 회원 정보의 삭제
     * @param userId
     * @return
     */
    public boolean delete(String userId){

        String sql = "DELETE FROM MEMBER WHERE userId = ?";

        int cnt = jdbcTemplate.update(sql, userId);

        return cnt > 0;
    }

    /**
     * 전체 회원 수
     * @return
     */
    public long getTotal(){
        long total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", long.class);

        return total;
    }




}
