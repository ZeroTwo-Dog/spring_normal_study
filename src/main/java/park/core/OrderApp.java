package park.core;

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
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    Long memberId = 1L;

    Member memberA = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(memberA);

    Order order = orderService.createOrder(memberId, "itemA", 10000);

    System.out.println(order.toString());
    System.out.println("calPrice: " + order.calPrice());

  }

}
