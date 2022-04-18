package hello.core.member;

import hello.core.discount.Order;
import hello.core.discount.OrderService;
import hello.core.discount.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order =  orderService.createOrder(memberId, "snack", 3000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
