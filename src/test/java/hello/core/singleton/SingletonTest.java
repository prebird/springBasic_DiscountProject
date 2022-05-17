package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService = " + memberService);
        System.out.println("memberService2 = " + memberService2);

        // 테스트 자동화
        Assertions.assertThat(memberService).isNotSameAs(memberService2);

        // 순수한 DI 컨테이너는 요청을 할 때마다 객체를 계속 생성한다.
        // -> 생성된 객체 인스턴스를 공유하도록 -> 싱글톤 컨테이너
    }

    @Test
    @DisplayName("싱글톤 컨테이너 사용")
    void singletonContainer(){
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        Assertions.assertThat(instance1).isSameAs(instance2);

        //same == -> 주솟값비교
        //equal equal 함수
    }
}
