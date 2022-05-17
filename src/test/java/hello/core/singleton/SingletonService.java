package hello.core.singleton;

public class SingletonService {
    // private로 static으로 생성 -> 스태틱 레벨에 하나만 하나만 생성됨
    // 자기자신을 인스턴스로 생성해서 대기중
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    // 밖에서 new 못하도록 선언
    private SingletonService() {
    }


    // 모든 빈을 이렇게 코드를 적어야 하냐? NO -> 스프링 컨테이너가 싱슬톤으로 관리해줌
}
