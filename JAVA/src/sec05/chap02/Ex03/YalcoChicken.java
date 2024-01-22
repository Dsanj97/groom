package sec05.chap02.Ex03;

public class YalcoChicken {
    int no;
    String name;

    // 1. 클래스의 요소로 배열이 들어갈수 있다
    // 2. 클래스의 인스턴스들이 포함될수 있다.
    ChickenMenu[] menus;

    // 메뉴들의 배열을 받음
    YalcoChicken (int no, String name, ChickenMenu[] menus) {
        this.no = no;
        this.name = name;
        this.menus = menus;
    }

    ChickenMenu orderMenu (String name) {
        for (ChickenMenu menu : menus) {
            if (menu.name.equals(name)) { // 🔴
                return menu;
            }
        }
        return null;
    }
}