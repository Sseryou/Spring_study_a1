package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
    @Autowired
    //스프링 컨테이너 안에 있으면 꺼내서 주입해준다.
    private MemberDao memberDao;

    public ListService() {}

    public ListService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public void print(){
        List<Member> members = memberDao.gets();
        members.stream().forEach(System.out::println);
    }

}
