package park.core.discount;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import park.core.config.AppConfig;
import park.core.domain.Grade;
import park.core.domain.Member;
import park.core.domain.Order;
import park.core.service.MemberService;
import park.core.service.OrderService;

class RateDiscountPolicyServiceTest {

  MemberService memberService;
  OrderService orderService;

  @BeforeAll
  static void beforeAll()  {
    System.out.println("beforeAll");
  }

  @BeforeEach
  public void beforeEach() {
        System.out.println("beforeEach");

//    AppConfig appConfig = new AppConfig();


    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    memberService = context.getBean("memberService", MemberService.class);
    orderService = context.getBean("orderService", OrderService.class);
  }
  
  @Test
  @Disabled
  @DisplayName("VIP는 10%할인이 적용되어야한다.")
  public void vip_o() {
    //given
    Member member = new Member(1L, "memberVIP", Grade.VIP);
    memberService.join(member);

    //when
    Order order = orderService.createOrder(1L, "ItemA", 20000);
    //then
    assertThat(order.getDiscountPrice()).isEqualTo(2000);
  }


  @Test
  @DisplayName("VIP가 아닌경우")
  public void vip_x() {
    //given
    Member member = new Member(2L, "memberBASIC", Grade.BASIC);
    memberService.join(member);


    //when
    Order order = orderService.createOrder(2L, "ItemA", 20000);
    //then
    assertThat(order.getDiscountPrice()).isEqualTo(0);
  }

}