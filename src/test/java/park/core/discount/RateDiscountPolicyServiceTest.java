package park.core.discount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import park.core.domain.Grade;
import park.core.domain.Member;
import park.core.service.discount.RateDiscountPolicyService;

class RateDiscountPolicyServiceTest {

  RateDiscountPolicyService rateDiscountPolicyService = new RateDiscountPolicyService();

  @Test
  @DisplayName("VIP는 10%할인이 적용되어야한다.")
  public void vip_o() {
    //given
    Member member = new Member(1L, "memberVIP", Grade.VIP);

    //when
    int discount = rateDiscountPolicyService.discount(member, 20000);
    //then
    assertThat(discount).isEqualTo(2000);
  }


  @Test
  @DisplayName("VIP가 아닌경우")
  public void vip_x() {
    //given
    Member member = new Member(1L, "memberVIP", Grade.BASIC);

    //when
    int discount = rateDiscountPolicyService.discount(member, 20000);
    //then
    assertThat(discount).isEqualTo(0);
  }

}