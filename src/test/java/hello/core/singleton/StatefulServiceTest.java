package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // Thread A: A사용자가 10000원 주문
        int price1 = statefulService1.order("name1", 10000);
        // Thread B: B사용자가 20000원 주문
        int price2 = statefulService1.order("name1", 20000);

        //ThreadA가 사용자 A가 주문금액을 조회
        //int price = statefulService1.getPrice();
        System.out.println("price = " + price1);

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }
    
    // 스프링 컨테이너에 해당 서비스 등록용 컨피그
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}