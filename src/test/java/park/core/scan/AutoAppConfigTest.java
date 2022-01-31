package park.core.scan;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import park.core.config.AutoAppConfig;
import park.core.service.MemberService;

/**
 * Created by park on 2022/01/31.
 */
public class AutoAppConfigTest {

  @Test
  void basicScan () {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    MemberService memberService = ac.getBean("memberService", MemberService.class);

    assertThat(memberService).isInstanceOf(MemberService.class);
  }

}
