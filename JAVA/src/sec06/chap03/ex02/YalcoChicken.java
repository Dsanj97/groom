package sec06.chap03.ex02;

public class YalcoChicken {

    private String name;
    public YalcoChicken(String name){
        this.name = name;
    }

    // 매장 신설시 임시로 만듬
    // 매장 신설 TF팀
    // static ==> 본사의 느낌
    public static class LaunchTF {
        private String title;
        private String leader;

        public LaunchTF(String title, String leader) {
            this.title = title;
            this.leader = leader;
        }

        public YalcoChicken launch() {
            // ⚠️인스턴스 필드는 사용 불가
            //System.out.println(this.name);
            return new YalcoChicken(title);
        }
    }

    // 매장마다의 기프트 - 배장에서 배부
    class Gift {
        private String message;

        public Gift(String to) {
            this.message = "From 얄코치킨 %s점 to %s님"
                    .formatted(name, to);
        }
    }

    // Gift클래스의 경우 static이 아니기때문에
    // 인스턴스를 반환하는 메소드를 외부 클래스안에 만들어야함
    public Gift getGift (String to) {
        return new Gift(to);
    }
}
