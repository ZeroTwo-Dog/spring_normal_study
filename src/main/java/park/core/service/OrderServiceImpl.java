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

  private final MemberRepository memberRepository = new MemoryMemberRepository();
//  private DiscountPolicyService discountPolicy;
  private final DiscountPolicyService discountPolicy = new FixDiscountPolicyService();

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
