package hello.core.member;

public interface MemberRepository {

    // 회원 저장 기능
    void save(Member member);

    // 회원 찾기 기능
    Member findById(Long memberId);

}
