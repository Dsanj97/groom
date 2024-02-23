package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor // final 을 가진 부분에서만 생성자를 만등러줌 --> 생성자를 따로 만들필요가 없어진다
public class MemberService {

    private final MemberRepository memberRepository; // 방금 만든 맴버 레파지토리

    // @Autowired // 생성자 인잭션으로 만들어주기 생성자가 하나라 @Autowired 생략 가능
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }



    // 회원 가입
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member); //중복 회원이 있는지 검사
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 문제있을시 예외터트릴꺼임
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    @Transactional(readOnly = true) // 조금더 최적화
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 아이디로 하나만 조회
    @Transactional(readOnly = true)
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
