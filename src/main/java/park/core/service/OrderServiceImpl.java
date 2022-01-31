package park.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import park.core.domain.Member;
import park.core.domain.Order;
import park.core.repository.MemoryMemberRepository;
import park.core.repository.MemberRepository;
import park.core.service.discount.DiscountPolicyService;
import park.core.service.discount.FixDiscountPolicyService;

/**
 * Created by park on 2021/11/20.
 */
@Component
public class OrderServiceImpl implements OrderService{

  private final MemberRepository memberRepository;
  private final DiscountPolicyService discountPolicy;

  @Autowired
  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicyService discountPolicy) {
     this.memberRepository = memberRepository;
     this.discountPolicy = discountPolicy;
  }

  public MemberRepository getMemberRepository() {
    return memberRepository;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
