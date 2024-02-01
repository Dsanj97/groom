package sec11.chap04.ex01;

import java.util.Random;

public class ATM {
    // 남은 잔액
    private int balance = 0;

    // 입금
    public  void addMoney(int amount) {
        balance += amount;
    }

    // 남은 잔댁 반환
    public int getBalance() {
        return balance;
    }

    //출금
    //  💡 앞에 synchronized를 붙이고 다시 실행해 볼 것
    public void withdraw (String name, int amount) {

        //  💡 또는 아래 내용을 이 블록으로 옮겨 볼 것
        //  - this는 현 쓰레드를 의미함
        //  - 메소드 내의 특정 작업만 동기화가 필요할 때
        synchronized (this) {

            // 만약 잔액이 출금하려는 금액보다 작다면
            if (balance < amount) return;

            // 인출시 시간 지연 발생
            System.out.printf(
                    "💰 %s 인출요청 (현 잔액 %d)%n",
                    name, balance
            );
            try {
                Thread.sleep(new Random().nextInt(700, 1000));
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            // 잔액 줄여주기
            balance -= amount;
            System.out.printf(
                    "✅ %s 인출완료 (현 잔액 %d)%n",
                    name, balance
            );
        }


    }
}
