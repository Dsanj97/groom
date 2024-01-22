package sec06.chap02.pkg1;

public class Friend {
    // Parent 와 같은 패키지
    Parent parent = new Parent();

    // 이것도 사용할수 없음
    //int aa = new Parent().a;

    int bb = parent.b;
    int cc = parent.c;
}
