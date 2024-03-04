package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor // 생성자를 자동 생성해주고 final 붙은것만 생성자 주입시킨다
public class MemberRepository {

    // @PersistenceContext // 스프링이 엔티티 메니저를 만들어서 주입해줌
    private final EntityManager em;

    public void save(Member member){ em.persist(member); }

    public Member findOne(Long id){ return em.find(Member.class, id); }

    // 회원 전체 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) //(jpql? ==> 엔타티 객체로 쿼리 , 반환타입)
                .getResultList(); // => 맴버를 리스트로 만들어줌
    }

    // 이름으로 검색
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name )
                .getResultList();
    }
}
