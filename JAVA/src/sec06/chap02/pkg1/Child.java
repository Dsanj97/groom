package sec06.chap02.pkg1;

public class Child extends Parent {
    // Parent 와 같은 패키지
    // parent 에서 상속 받았다 한들 protected 르 보호 받고있어
    // 자식클레스에서도 사용할수 없다
    // int aa = a

    // 디폴트는 동일 패키지에서는 다가능
    int bb = b;

    int cc = c;
}
