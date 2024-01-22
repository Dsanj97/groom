package sec05.chap05.ex01;

public class ShutDownButton extends Button {
    // Button클래스를 상속받은 클래스
    // 여기선 Button 의 기능들을 사용할수 있다

    // 생성자
    public ShutDownButton () {
        super("ShutDown"); // 💡 부모의 생성자 호출
    }

    //  💡 부모의 메소드를 override
    // @ 는없어도 상관없지만 이름이 달라질경우 오류를 툴력해준다
    @Override
    public void func () {
        System.out.println("프로그램 종료");
    }
}