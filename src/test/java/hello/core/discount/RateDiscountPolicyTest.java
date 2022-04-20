package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10프로 할인이 적용되어야한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member, 3000);

        //then
        assertThat(discount).isEqualTo(300); //arlt enter static import

    }

    @Test
    @DisplayName("VIP가 아니면 할인정책이 적용되면 안된다")
    void Vip_x(){
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 3000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}