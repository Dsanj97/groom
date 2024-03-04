package memberEx;

import hellojpa.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        // 모든 데이터베이스의 변경읜트랜잭션 인에서먼 수행
        EntityTransaction tx = em.getTransaction();
        // 트랜잭션 시작
        tx.begin();

        try {
            MemberEx01 memberEx01 = new MemberEx01();
            System.out.println("Main.main");

            memberEx01.setId(1L);
            memberEx01.setName("dsa");
            memberEx01.setAge(2);
            memberEx01.setCreateTime(new Date());
            memberEx01.setRoleType(RoleType.USER);

            em.persist(memberEx01);

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
