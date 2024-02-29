package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmCache {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        // 모든 데이터베이스의 변경은 트랜잭션 인에서먼 수행
        EntityTransaction tx = em.getTransaction();
        // 트랜잭션 시작
        tx.begin();

        try {

            // 비영속
            Member member = new Member();
            member.setId(1L);
            member.setName("test");

            // 영속
            // 디비에 쿼리를 바로 날리지는 않음
            em.persist(member);

            em.find(Member.class, 1L);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }


}
