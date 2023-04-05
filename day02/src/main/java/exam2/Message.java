package exam2;

public class Message {

    //통제할수 없는 클래스라 가정하고 제작

    public void init(){
        System.out.println("init!!");
    }

    public void send(String msg){
        System.out.printf("전송 메세지 : %s%n", msg);
    }
    public void close(){
        System.out.println("close!!");
    }

}
