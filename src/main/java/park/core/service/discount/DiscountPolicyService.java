package park.core.service.discount;

import park.core.domain.Member;

public interface DiscountPolicyService {

  /**
   *
   * @return 할인 대상 금액
   */
  int discount(Member member, int price);

}
