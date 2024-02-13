package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 스피링 빈 으로 자동 등록
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired //MemberRepository 타입에 맞는 빈을 자동으로 찾아 등록해준다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 싱글톤 확인을 위한 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
