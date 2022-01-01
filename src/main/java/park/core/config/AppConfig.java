package park.core.config;

import park.core.repository.MemberRepository;
import park.core.repository.MemoryMemberRepository;
import park.core.service.MemberService;
import park.core.service.MemberServiceImpl;
import park.core.service.OrderService;
import park.core.service.OrderServiceImpl;
import park.core.service.discount.DiscountPolicyService;
import park.core.service.discount.FixDiscountPolicyService;
import park.core.service.discount.RateDiscountPolicyService;

/**
 * Created by park on 2021/12/18.
 */
public class AppConfig {

  //생성자 주입
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), fixDiscountPolicy());
  }


  public OrderService orderRateService() {
    return new OrderServiceImpl(memberRepository(), rateDiscountPolicy());
  }

  public DiscountPolicyService rateDiscountPolicy() {
    return new RateDiscountPolicyService();
  }

  public DiscountPolicyService fixDiscountPolicy() {
    return new FixDiscountPolicyService();
  }
}
