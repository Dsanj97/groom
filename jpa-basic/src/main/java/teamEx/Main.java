package teamEx;

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
            // 저장
            Team team = new Team();
            team.setName("Team1");
            em.persist(team);

            Member member = new Member();
            member.setUsername("dong");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member member1 = em.find(Member.class, member.getId());
            List<Member> members = member1.getTeam().getMembers();

            for (Member member2 : members) {
                System.out.println("members = " + member2.getUsername());
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
