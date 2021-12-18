package park.core.config;

import park.core.repository.MemoryMemberRepository;
import park.core.service.MemberService;
import park.core.service.MemberServiceImpl;
import park.core.service.OrderService;
import park.core.service.OrderServiceImpl;
import park.core.service.discount.FixDiscountPolicyService;
import park.core.service.discount.RateDiscountPolicyService;

/**
 * Created by park on 2021/12/18.
 */
public class AppConfig {

  //생성자 주입
  public MemberService memberService() {
    return new MemberServiceImpl(new MemoryMemberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicyService());
  }


  public OrderService orderRateService() {
    return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicyService());
  }
}
