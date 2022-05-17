package hello.core.member;
import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    // concurrent hashmap을 실무에서는 씀 (동시성 이슈 때문)
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
