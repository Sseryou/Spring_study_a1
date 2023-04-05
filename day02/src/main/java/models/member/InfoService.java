package models.member;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class InfoService {

    private MemberDao memberDao;

    //스캔 범위 안에 있으면, 생성자 매개변수로 만들어도 주입이 된다는 것을 보여준다.
    //명시하지 않아도 주입이 된다.
    public InfoService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    //Optional 형태로 된 값도 주입받을 수 있다.
//    @Autowired
//    private Optional<MemberDao> opt;



    //호출이 되지 않으므로, 값이 유지가 된다
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public void print(String userId){
        //MemberDao memberDao = opt.get();
        Member member = memberDao.get(userId);

        //formatter가 없으면 실행되지 않게 한다.
        //nullpoint 예외를 막는다.
        if(formatter != null) {
            String dateStr = formatter.format(member.getRegDt());
            member.setRegDtStr(dateStr);
        }

        System.out.println(member);
    }

    //@Autowired(required = false)
    //required가 false이면 의존하는 객체가 없으면 호출 자체가 안된다.
    @Autowired //의존성 주입, 호출
    //Nullable이 있으면, 의존성이 없으면 Null값을 넣고 호출을 하게 된다.
    public void setFormatter(@Nullable DateTimeFormatter formatter){
        this.formatter = formatter;
    }

}
