package sec06.chap07.ex05;

public class Main {
    public static void main(String[] args) {

        // 아무 유닛이나 태우는 말
        Horse<Unit> avante = new Horse<>();
        avante.setRider(new Unit());
        avante.setRider(new Knight());
        avante.setRider(new MagicKnight());

        // 기사 계급 이상을 태우는 말
        Horse<Knight> sonata = new Horse<>();
        //sonata.setRider(new Unit()); // ‼️불가
        sonata.setRider(new Knight());
        sonata.setRider(new MagicKnight());

        // 마법 기사만 태우는 말
        Horse<MagicKnight> grandeur = new Horse<>();
        //grandeur.setRider(new Unit());
        //grandeur.setRider(new Knight());
        grandeur.setRider(new MagicKnight());


        // ⚠️ 자료형과 제네릭 타입이 일치하지 않으면 대입 불가
        // - 제네릭 타입이 상속관계에 있어도 마찬가지
//        Horse<Unit> wrongHorse1 = new Horse<>(Knight);
//        Horse<Knight> wrongHorse2 = new Horse<>(Unit);
//        avante = sonata;
//        sonata = grandeur;


        // ⭐️와일드 카드 - 제네릭 타입의 타형성을 위함

        // 💡Knight 과 그 자식 클래스만 받을수 있음
        // 기사 계급 이상을 태우는 말 이상만 대입 받을수 있는 변수

        Horse<? extends Knight> knightHores;
        // 기사 혹은 기사를 상속받는것들을 태울수 있다.
        //knightHores = new Horse<Unit>(); // ‼️불가
        knightHores = new Horse<Knight>();
        knightHores = new Horse<MagicKnight>();
        //knightHores = avante; // ‼️불기
        knightHores = sonata;
        knightHores = grandeur;

        // 💡반대로 기사와 기사 아래클래스들만 탈수 있는 말
        Horse<? super Knight> nonLuxuryHorse;
        nonLuxuryHorse = avante;
        nonLuxuryHorse = sonata;
        //nonLuxuryHorse = grandeur; // ‼️불가

        // 💡제한 없음 - <? extends Unit> 과 동일
        // 어떤 말이든 받는 변수
        Horse<?> anyHorse;
        anyHorse = avante;
        anyHorse = sonata;
        anyHorse = grandeur;
    }
}
