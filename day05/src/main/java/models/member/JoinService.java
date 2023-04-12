package models.member;


import controllers.members.Join;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final MemberDao memberDao;

    public void join(Join join){
        //비밀번호 해시화 - BCrypt
        String hash = BCrypt.hashpw(join.getUserPw(), BCrypt.gensalt(10));

        Member member = new Member();
        member.setUserId(join.getUserId());
        member.setUserPw(hash);
        member.setUserNm(join.getUserNm());
        member.setEmail(join.getEmail());

        memberDao.insert(member);

    }


}
