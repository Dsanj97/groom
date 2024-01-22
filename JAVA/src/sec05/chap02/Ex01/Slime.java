package sec05.chap02.Ex01;

public class Slime {
        // 기본값을 클래스에서 초기화 할수있다라는 점
    double hp = 50;
    int attack = 8;
    double defense = 0.2;

    // 이런 클래ㅔ스도 자료형이이기 떄문에 어떤 변수나 인자로 활용할수 있다는것
    void attack (Slime enemy) { // 💡 다른 슬라임의 인스턴스를 인자로 받음
        enemy.hp -= attack * (1 - enemy.defense);
    }
}