package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository ;

    // 생성자를 통해서 넣어줌 -> 이 코드에는 MemoryMemberRepository(구현)이 없음 -> DIP준수
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
}
