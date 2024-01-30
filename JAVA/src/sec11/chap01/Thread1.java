package sec11.chap01;

public class Tread1 extends Thread{
    @Override
    public void run() {

        for (var i = 0; i < 20; i++){
            // 😴
            System.out.println(1);
        }
    }
}
