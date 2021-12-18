package park.core.service.discount;

import park.core.domain.Grade;
import park.core.domain.Member;

/**
 * Created by park on 2021/11/20.
 */
public class RateDiscountPolicyService implements DiscountPolicyService{

  private  int discountPercent = 10;


  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return price * discountPercent / 100;
    } else {
      return 0;
    }
  }
}
