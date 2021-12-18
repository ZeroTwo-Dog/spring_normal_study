package park.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import park.core.config.AppConfig;
import park.core.domain.Grade;
import park.core.domain.Member;
import park.core.service.MemberService;
import park.core.service.MemberServiceImpl;

/**
 * Created by park on 2021/11/20.
 */
public class MemberServiceTest {

  MemberService memberService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
  }
  @Test
  void join() {
    //given
    Member member = new Member(1L, "memberA", Grade.VIP);

    //when
    memberService.join(member);
    Member findMember = memberService.findMember(1L);

    //then
    Assertions.assertThat(member).isEqualTo(findMember);
  }

}
