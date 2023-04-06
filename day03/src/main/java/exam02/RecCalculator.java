package exam02;

import exam02.Calculator;

public class RecCalculator implements Calculator {

    //본인 함수를 계속 호출하며 계산하는 재귀적 방식 사용
    public long factorial(long num) {
        long startTime = System.nanoTime();

            if (num == 0) {
                return 1;
            }

            return num * factorial(num - 1);


        //try부분 삭제됨
        //return은 함수를 끝내지만, try~finally가 있다면 finally도 실행한다
        //return한다 해도 finally를 실행해야 끝나는 원리 이용

    }
}
