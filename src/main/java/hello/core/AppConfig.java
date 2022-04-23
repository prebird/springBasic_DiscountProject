package hello.core;

import hello.core.discount.*;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){                   // 멤버 서비스는
        return new MemberServiceImpl(memberRepository());  //서비스임플 사용함
    }

    @Bean
    public MemberRepository memberRepository(){             // 리포지토리는
        return new MemoryMemberRepository();                // 메모리
    }

    @Bean
    public OrderService orderService(){                                 // 오더 서비스는
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // impl
    }
    
    @Bean
    public DiscountPolicy discountPolicy(){  //할인율은
        return new RateDiscountPolicy();                                         // 변경가능 할인율
    }
}
