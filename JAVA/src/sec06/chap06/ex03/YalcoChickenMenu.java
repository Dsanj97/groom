package sec06.chap06.ex03;

import sec06.chap03.ex02.YalcoChicken;

public enum YalcoChickenMenu {
    FR("후라이드", 10000, 0),
    YN("양념치킨", 12000, 1),
    GJ("간장치킨", 12000, 0),
    RS("로제치킨", 14000, 0),
    PP("땡초치킨", 13000, 2),
    XX("폭렬치킨", 13000, 3);

    private String name;
    private int price;
    private  int spicyLevel;

    YalcoChickenMenu(String name, int price, int spicyLevel){
        this.name = name;
        this.price = price;
        this.spicyLevel = spicyLevel;
    }

    // geter
    public String getName(){
        return name;
    }
    public int getPrice() {
        return price;
    }

    // setter 가격 설정
    public void setPrice(int price){
        this.price = price;
    }

    // 반환값을 커스터 마이징도 가능
    public String getDesc() {
        String peppers = "";
        if (spicyLevel > 0){
            peppers = "🌶️".repeat(spicyLevel);
        }
        return "%s %s원 %s"
                .formatted(name, price, peppers);
    }

}
