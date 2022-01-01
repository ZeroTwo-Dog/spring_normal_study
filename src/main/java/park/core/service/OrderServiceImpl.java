package park.core.service;

import park.core.domain.Member;
import park.core.domain.Order;
import park.core.repository.MemoryMemberRepository;
import park.core.repository.MemberRepository;
import park.core.service.discount.DiscountPolicyService;
import park.core.service.discount.FixDiscountPolicyService;

/**
 * Created by park on 2021/11/20.
 */
public class OrderServiceImpl implements OrderService{

  private final MemberRepository memberRepository;
  private final DiscountPolicyService discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicyService discountPolicy) {
     this.memberRepository = memberRepository;
     this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
