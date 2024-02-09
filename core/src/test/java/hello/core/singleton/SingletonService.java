package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // new 로 계속 찍어낼수 있으므로 private 생성자를 사용한다
    // 외부에서 생성자 접근 불가능!!
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글턴 객체 로직 호출");
    }
}
