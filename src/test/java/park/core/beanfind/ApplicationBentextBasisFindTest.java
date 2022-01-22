package park.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import park.core.config.AppConfig;
import park.core.service.MemberService;
import park.core.service.MemberServiceImpl;

/**
 * Created by park on 2022/01/22.
 */
public class ApplicationBentextBasisFindTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


  @Test
  @DisplayName("빈 이름 조회")
  void findByName () {
    MemberService memberService = ac.getBean("memberService", MemberService.class);

    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("빈 이름 없이 타입 조회")
  void findByType () {
    MemberService memberService = ac.getBean(MemberService.class);

    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("구체 타입으로 조회")
  void findByName2 () {
    MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);

    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("빈 이름 조회 X")
  void findByNameX () {
    assertThrows(NoSuchBeanDefinitionException.class, ()
        ->  ac.getBean("memberServiceX", MemberService.class));

  }


}
