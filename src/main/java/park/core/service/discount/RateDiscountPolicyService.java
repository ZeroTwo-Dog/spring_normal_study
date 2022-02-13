package park.core.service.discount;

import org.springframework.stereotype.Component;
import park.core.annotatioon.MainDiscountPolicy;
import park.core.domain.Grade;
import park.core.domain.Member;

/**
 * Created by park on 2021/11/20.
 */
@Component
@MainDiscountPolicy
public class RateDiscountPolicyService implements DiscountPolicyService{


  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      int discountPercent = 10;
      return price * discountPercent / 100;
    } else {
      return 0;
    }
  }
}
