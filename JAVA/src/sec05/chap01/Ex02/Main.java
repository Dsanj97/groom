package sec05.chap01.Ex02;

public class Main {
    public static void main(String[] args) {

        // 얄코치킨 매장 을 내는 코드
        YalcoChicken store1 = new YalcoChicken();
        // store1 의 매장 번호
        store1.no = 3;
        // 매장의 이름
        store1.name = "판교";

        YalcoChicken store2 = new YalcoChicken();
        store2.no = 12;
        store2.name = "강남";

        // 인스턴스 필드들에게 접근하는 방법
        int store1No = store1.no;
        String store2Name = store2.name;

        // 인스턴스 매소드 호출
        String store1Intro = store1.intro();

    }
}
