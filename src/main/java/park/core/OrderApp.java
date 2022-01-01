package park.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class OrderApp {

  public static void main(String[] args) {
//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();
//    OrderService orderService = appConfig.orderService();

    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberService memberService = context.getBean("memberService", MemberService.class);
    var orderService = context.getBean("orderService", OrderService.class);

    Long memberId = 1L;

    Member memberA = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(memberA);

    Order order = orderService.createOrder(memberId, "itemA", 10000);

    System.out.println(order.toString());
    System.out.println("calPrice: " + order.calPrice());

  }

}
