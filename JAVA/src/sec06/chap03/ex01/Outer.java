package sec06.chap03.ex01;

public class Outer {
    private String inst = "인스턴스";
    private  static  String sttc = "클래스";

    // 1. 맴버 인스턴스 클래스
    // 외부의 필드에 접근하여 사용 가능
    // 정적 내부 클래스를 가져다 쓸수 있다
    class InnerInstMenber {
        // ⭐ 외부 클래스의 필드와 클래스 접근 가능
        private String name = inst + " 필드로서의 클래스";
        private  InnerInstMenber innerInstMenber = new InnerInstMenber();

        public void func() {
            System.out.println(name);
        }
    }


    // 2. 정적(클래스) 내부 클래스
    // ⭐️내부 클래스에도 접근자 사용 가능. private으로 바꿔볼것
    public static class InnerSttcMember {
        // ⭐ 외부 클래스의 클래스 필드만 접근 가능
        // static 만 접근 가능
        private String name = sttc + " 필드로서의 클래스";
        //private String name2 = inst + " 접근 불가";

        // ⚠️ static이 아닌 멤버 인스턴스 클래스에도 잡근 불가!
        //private InnerInstMenber innerInstMenber = new InnerInstMenber();


        public void func() {
            // ⚠️인스턴스 메소드지만 클래스가 정적(클래스의)이므로 인스턴스 필드 접근 불가
            // name += inst;
            System.out.println(name);
        }
    }

    public void memberFunc() {
        //💡 3. 메소드 안에 정의된 클래스
        // 스코프가 메소드 내로 제한됨
        class MethodMember {
            String instSttc = inst + " " + sttc;
            InnerInstMenber innerInstMenber = new InnerInstMenber();
            InnerSttcMember innerSttcMember = new InnerSttcMember();

            public void func() {
                innerInstMenber.func();
                innerSttcMember.func();
                System.out.println("메소드 안의 클래스");
            }
        }

        // 메소드 안에서만 쓸수 있는 클래스
        new MethodMember().func();
    }

    // outer의 메소드에서
    // 인스턴스 클래스 와 정적 내부 클래스 모두 접근 가능
    public void innerFuncs() {
        new InnerInstMenber().func();
        new InnerSttcMember().func();
    }

    public InnerInstMenber getInnerInstMember() {
        return new InnerInstMenber();
    }
}
