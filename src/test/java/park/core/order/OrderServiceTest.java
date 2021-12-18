package park.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import park.core.config.AppConfig;
import park.core.domain.Grade;
import park.core.domain.Member;
import park.core.domain.Order;
import park.core.service.MemberService;
import park.core.service.MemberServiceImpl;
import park.core.service.OrderService;
import park.core.service.OrderServiceImpl;

/**
 * Created by park on 2021/12/18.
 */
public class OrderServiceTest {

  MemberService memberService;
  OrderService  orderService;

  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();

    orderService = appConfig.orderService();
  }
  @Test
  public void createOrder() {
    //given
    Long memberId = 1L;

    Member memberA = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(memberA);

    //when
    Order order = orderService.createOrder(memberId, "itemA", 10000);

    //then
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }

}
