package sec06.chap03.ex01;

public class Main {
    public static void  main(String[] args) {

        Outer.InnerSttcMember staticMember = new Outer.InnerSttcMember();
        staticMember.func();

        System.out.println("\n- - - - -\n");

        Outer outer = new Outer();
        outer.innerFuncs();

        System.out.println("\n- - - - -\n");

        // 💡인스턴스 내부 클래스는 이렇게 얻을수 있음
        Outer.InnerInstMenber innerInstMenber = outer.getInnerInstMember();
        innerInstMenber.func();
    }
}
