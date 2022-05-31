package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository ;

    // 생성자를 통해서 넣어줌 -> 이 코드에는 MemoryMemberRepository(구현)이 없음 -> DIP준수
    @Autowired // AppConfig 없이 자동 의존관계 주입 // 인터페이스에 해당하는 빈으로 등록된 클래스를 넣어줌
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
