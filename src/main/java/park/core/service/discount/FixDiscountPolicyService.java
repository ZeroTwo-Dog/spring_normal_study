package park.core.service.discount;

import park.core.domain.Grade;
import park.core.domain.Member;

/**
 * Created by park on 2021/11/20.
 */
public class FixDiscountPolicyService implements DiscountPolicyService {

  private int discountFixAmount = 1000;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    } else {
      return 0;
    }
  }
}
