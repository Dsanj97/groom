package sec06.chap02.pkg4;

import sec06.chap02.pkg1.Parent;
import sec06.chap02.pkg3.*; // ⭐와일드 카드

public class Main {
    public static void main(String[] args) {
        // ⭐️
        Parent parent = new Parent();

        // ⭐패키지가 다른 동명의 클레스들을 불러올 경우
        sec06.chap02.pkg1.Child child1 = new sec06.chap02.pkg1.Child();
        sec06.chap02.pkg2.Child child2 = new sec06.chap02.pkg2.Child();

        Cls1 cls1 = new Cls1();
        Cls2 cls2 = new Cls2();
        Cls3 cls3 = new Cls3();

    }
}
