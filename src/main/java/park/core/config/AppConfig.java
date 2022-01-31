package park.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@Configuration
public class AppConfig {

  //생성자 주입
  @Bean
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  @Bean
  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), rateDiscountPolicy());
  }

  @Bean
  public OrderService orderRateService() {
    return new OrderServiceImpl(memberRepository(), rateDiscountPolicy());
  }

  @Bean
  public DiscountPolicyService rateDiscountPolicy() {
    return new RateDiscountPolicyService();
  }

//  @Bean
//  public DiscountPolicyService fixDiscountPolicy() {
//    return new FixDiscountPolicyService();
//  }
}
