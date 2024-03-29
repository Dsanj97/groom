package sec08_CollectionFramework;

import sec07Game.*;

import java.util.*;

public class chap08_iterator {
    public static void main(String[] args) {
        Set<Integer> intHSet = new HashSet<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
        );

        //  💡 이터레이터 반환 및 초기화
        //  - 기타 Collection 인터페이스를 구현한 클래스들에도 존재
        Iterator<Integer> intItor = intHSet.iterator();

        // 💡 next : 자리를 옮기며 다음 요소 반환
        Integer int1 = intItor.next();
        Integer int2 = intItor.next();
        Integer int3 = intItor.next();

        //  💡 hasNext : 순회가 끝났는지 여부 반환
        boolean hasNext = intItor.hasNext();

        //  ⭐️ 순회 초기화
        intItor = intHSet.iterator();
        Integer int4 = intItor.next();


        //  💡 remove : 현 위치의 요소 삭제
        while (intItor.hasNext()) {
            if (intItor.next() % 3 == 0) {
                intItor.remove();
            }
        }

        //  ⚠️ foreach 문으로 시도하면 오류
//        for (Integer num : intHSet) {
//            if (num % 3 == 0) intHSet.remove(num);
//        }

        List<Unit> enemies = new ArrayList<>(
                Arrays.asList(
                        new Swordman(Side.RED),
                        new Knight(Side.RED),
                        new Swordman(Side.RED),
                        new Swordman(Side.RED),
                        new Knight(Side.RED),
                        new Knight(Side.RED),
                        new Swordman(Side.RED),
                        new MagicKnight(Side.RED),
                        new Swordman(Side.RED),
                        new MagicKnight(Side.RED),
                        new Knight(Side.RED),
                        new MagicKnight(Side.RED))
        );

        Iterator<Unit> enemyItor = enemies.iterator();

        int thunderBolts = 3;
        int fireBalls = 4;

        while (enemyItor.hasNext() && thunderBolts-- > 0) {
            Unit enemy = enemyItor.next();
            System.out.printf("%s 벼락 공격%n", enemy);
            enemy.hp -= 50;
        }
        while (enemyItor.hasNext() && fireBalls-- > 0) {
            Unit enemy = enemyItor.next();
            System.out.printf("%s 파이어볼 공격%n", enemy);
            enemy.hp -= 30;
        }
        while (enemyItor.hasNext()) {
            Unit enemy = enemyItor.next();
            System.out.printf("%s 화살 공격%n", enemy);
            enemy.hp -= 10;
        }


        // Map 이터레이션
        System.out.println("\n- - - - -\n");

        Map<Integer, Double> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i + 1, Math.random() * 10);
        }

        //  ⭐️ 맵의 경우는 아래와 같이 이터레이션
        //  - 키, 값 또는 엔트리의 컬렉션을 반환받아 이터레이트

        // 키를 순회하는 이터래이터
        Iterator<Integer> hmKeyItor = hashMap.keySet().iterator();
        // 값을 순회하는 이터레이터
        Iterator<Double> hmValueItor = hashMap.values().iterator();
        // 키와 값을 모두 포함하는 이터레이터
        Iterator<Map.Entry<Integer, Double>> hmEntryItor = hashMap.entrySet().iterator();


        while (hmKeyItor.hasNext()) {
            System.out.println(hmKeyItor.next());
        }
        System.out.println("\n- - - - -\n");

        while (hmValueItor.hasNext()) {
            System.out.println(hmValueItor.next());
        }
        System.out.println("\n- - - - -\n");

        while (hmEntryItor.hasNext()) {
            System.out.println(hmEntryItor.next());
        }
    }
}
