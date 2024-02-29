package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        // 모든 데이터베이스의 변경읜트랜잭션 인에서먼 수행
        EntityTransaction tx = em.getTransaction();
        // 트랜잭션 시작
        tx.begin();


        // code

        try {
            // 맴버 객체 생성후
//            Member member = new Member();
//            member.setId(3L);
//            member.setName("hello12");
//            em.persist(member);
            //tx.commit();
            // 모든 디비의 변경사항은 트랜잭션 안에서 일어나야 한다

            // 변경이 생길경우
            // 맴버찾기
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.name = " + findMember.getName());
//            System.out.println("findMember.id = " + findMember.getId());

            // 이름 변경
            //findMember.setName("dsa");


            // persist 이용하여 객체를 저장
            //em.persist(member);

            // JPQL 예제 ==> 엔티티 객체를 대상으로 쿼리
            List<Member> re = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for (Member member : re) {
                System.out.println("member.name = " + member.getName());
                em.remove(member);
                System.out.println("지워진 객체 = " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            System.out.println("catch");
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
