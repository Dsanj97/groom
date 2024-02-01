package sec08_CollectionFramework;

import sec07Game.Side;
import sec07Game.Swordman;

import javax.swing.plaf.basic.BasicTreeUI;
import java.util.*;

public class chap08_Set {
    public static void main(String[] args) {
        /*
        Set ==> 중복되자 않는 요소들의 집합
        HashSet         성능리빠르고 메모리를 적게사용                | 순서관련 기능없음(보장하지 않음)
        LinkedHashSet   요소들을 입력순서대로 정렬 (내부적으로 링므 사용) | HashSet 보다는 성능 떨어짐
        TreeSet         요소들을 특정 기준대로 정렬(기본 오름 차순)     | 데이터 추가/삭제에 시간 더소모
        */

        Set<Integer> intHSet = new HashSet<>();
        intHSet.add(1);
        intHSet.add(1);
        intHSet.add(2);
        intHSet.add(3);

        List<Integer> ints1 = new ArrayList<>(
                Arrays.asList(1,1,2,2,3,3,4,5,6,7)
        );
        Set<Integer> intHSet2 = new HashSet<>(ints1);


        // 💡for-each문 사용가능
        for (var i :intHSet){
            System.out.println(i);
        }


        // ⭐️아래와 같이 사용 가능
        // - 중복을 제거한 ARRayList
        ints1.clear();
        ints1.addAll(intHSet2);

        // ⭐️️️⭐️️️⭐️️️⭐️️️Set 의 기본적인 메소드⭐️️️⭐️️️⭐️️️⭐️️

        // 호함 여부
        boolean has2 = intHSet.contains(2);
        boolean hsa4 = intHSet.contains(4);

        // 요소 삭제, 있었는지 여부 반영
        boolean rm3 = intHSet.remove(3);
        boolean rm4 = intHSet.remove(4);


        // 다른 콜랙션 기준으로 내용 삭제
        intHSet2.removeAll(intHSet);
        // 💡이것들 이외에도 aize, isEmpty, clear등의 메소드들 확인

        // 참조형 관련
        Set<Swordman> swordmanSet = new HashSet<>();
        Swordman swordman = new Swordman(Side.RED);

        swordmanSet.add(swordman);
        swordmanSet.add(swordman);
        swordmanSet.add(new Swordman(Side.RED));
        swordmanSet.add(new Swordman(Side.RED));

        HashSet<Integer> intHashSet = new HashSet<>();
        LinkedHashSet<Integer> intLinkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> intTreeSet = new TreeSet<>();

        for (int i : new int[] { 3, 1, 8, 5, 4, 7, 2, 9, 6}) {
            intHashSet.add(i);
            intLinkedHashSet.add(i);
            intTreeSet.add(i);
        }

        for (var s : new Set[] {intHashSet, intLinkedHashSet, intTreeSet}) {
            System.out.println(s);
        }
        // ⭐️LinkedHashSet : 입력된 순서대로 / TreeSet : 오름차순
        // ⚠️ HashSet이 정렬된것처럼 보이지만 보장된것이 아님
        // - Hash 형식에 의한 특정 조건에서의 정렬일뿐

        Set<String> strHashSet = new HashSet<>();
        Set<String> strLinkedHashSet = new LinkedHashSet<>();
        TreeSet<String> strTreeSet = new TreeSet<>();

        for (String s : new String[] {
                "Fox", "Banana", "Elephant", "Car", "Apple", "Game", "Dice"
        }) {
            strHashSet.add(s);
            strLinkedHashSet.add(s);
            strTreeSet.add(s);
        }
        for (var s : new Set[] {strHashSet, strLinkedHashSet, strTreeSet}) {
            System.out.println(s);
        }

        // 트리
        // 같은것이 없다면 트리 구조상 바로 위의것(바로 더큰것) 반환
        String foxCeiling = strTreeSet.ceiling("Fox");
        String creamCeiling = strTreeSet.ceiling("Cream");

        // 같은것이 없다면 트리 구조상 바로 아래것(바로 더 작은 것) 반환
        String foxFloor = strTreeSet.floor("Fox");
        String diceFloor = strTreeSet.floor("Cream");

        // 맨앞 맨뒤 에서 뽑기
        int pollFirst1 = intTreeSet.pollFirst();
        int pollFirst2 = intTreeSet.pollFirst();

        int pollLast1 = intTreeSet.pollLast();
        int pollLast2 = intTreeSet.pollLast();

        // 순서가 뒤잡힌 NavigableSet 반환
        Set<String> strTreeSetDesc
                = (TreeSet<String>) strTreeSet.descendingSet();

    }
}
