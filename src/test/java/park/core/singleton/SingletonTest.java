package park.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import park.core.config.AppConfig;
import park.core.service.MemberService;

/**
 * Created by park on 2022/01/22.
 */
public class SingletonTest {

  @Test
  @DisplayName("스프링 없는 순수한 DI 컨테이너")
  void pureContainer() {
    AppConfig appConfig =  new AppConfig();
    //1. 조회: 호출할때마다 객체 생성하는지
    MemberService memberService = appConfig.memberService();
    //2. 조회: 호출할때마다 객체 생성하는지
    MemberService memberService1 = appConfig.memberService();

    // 참조값이 다른지 확인
    System.out.println(memberService);
    System.out.println(memberService1);

    assertThat(memberService).isNotEqualTo(memberService1);

  }

  @Test
  @DisplayName("싱글톤 패턴을 적용한 객체 사용")
  void singletonServiceTest () {
    SingletonService singletonService1 = SingletonService.getInstance();
    SingletonService singletonService2 = SingletonService.getInstance();

    // 참조값이 다른지 확인
    System.out.println(singletonService1);
    System.out.println(singletonService2);


    //same ==
    //equals String.equal
     assertThat(singletonService1).isEqualTo(singletonService2);
  }


  @Test
  @DisplayName("싱글톤 컨테이너")
  void springContainer() {
    ApplicationContext ac = new
        AnnotationConfigApplicationContext(AppConfig.class);
    //1. 조회: 호출할때마다 객체 생성하는지
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    //2. 조회: 호출할때마다 객체 생성하는지
    MemberService memberService1 = ac.getBean("memberService", MemberService.class);

    // 참조값이 다른지 확인
    System.out.println(memberService);
    System.out.println(memberService1);

    assertThat(memberService).isSameAs(memberService1);
  }
}
