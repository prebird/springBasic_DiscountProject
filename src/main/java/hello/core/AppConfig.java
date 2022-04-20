package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.OrderService;
import hello.core.discount.OrderServiceImpl;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {

    // 생성자를 통해 주입한다고 해서 생성자 중입
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
