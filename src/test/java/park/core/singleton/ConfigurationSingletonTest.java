package park.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import park.core.config.AppConfig;
import park.core.repository.MemberRepository;
import park.core.service.MemberServiceImpl;
import park.core.service.OrderServiceImpl;

/**
 * Created by park on 2022/01/29.
 */
public class ConfigurationSingletonTest {
  @Test
  void configurationTest() {
    ApplicationContext ac = new
        AnnotationConfigApplicationContext(AppConfig.class);
    MemberServiceImpl memberService = ac.getBean("memberService",
        MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService",
        OrderServiceImpl.class);
    MemberRepository memberRepository = ac.getBean("memberRepository",
        MemberRepository.class);
  //모두 같은 인스턴스를 참고하고 있다.
    System.out.println("memberService -> memberRepository = " +
        memberService.getMemberRepository());
    System.out.println("orderService -> memberRepository  = " +
        orderService.getMemberRepository());
    System.out.println("memberRepository = " + memberRepository);

    //모두 같은 인스턴스를 참고하고 있다.

    assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
  }

  @Test
  void configurationDeep () {
    ApplicationContext ac = new
        AnnotationConfigApplicationContext(AppConfig.class);

    AppConfig appConfig = ac.getBean(AppConfig.class);

    System.out.println("bean = "+ appConfig.getClass());

  }

}
