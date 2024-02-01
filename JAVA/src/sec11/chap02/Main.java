package sec11.chap02;

public class Main {
    public static void main(String[] args) {
        Thread tarzanThread = new Thread(new TarzanRun(100));

        //💡Thread 에 이름 붙이기
        tarzanThread.setName("타잔송");
        tarzanThread.start();
    }
}
