package sec05.chap02.Ex03;

public class ChickenMenu {
    String name;
    int price;
    String cook = "fry";

    // 매소드 오버 로딩
    // 항상 fry로 요리함
    ChickenMenu (String name, int price) {
        this.name = name;
        this.price = price;
    }

    // 요리하는 방식을 다르게 줄떄 사용할수 있음
    ChickenMenu (String name, int price, String cook) {
        this.name = name;
        this.price = price;
        this.cook = cook;
    }
}