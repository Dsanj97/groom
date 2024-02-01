package sec11.chap04.ex01;

public class CustomerRun implements Runnable{
    String name;
    ATM atmToUse;
    int needed;

    public CustomerRun(String name, ATM atmToUse, int needed) {
        this.name = name;
        this.atmToUse = atmToUse;
        this.needed = needed;
    }

    @Override
    public void run() {
        // 해당 atm 이 출금할 잔액이 남아있는 동안
        while (atmToUse.getBalance() > needed){
            atmToUse.withdraw(name, needed);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
