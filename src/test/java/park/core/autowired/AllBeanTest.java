package park.core.autowired;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import park.core.config.AutoAppConfig;
import park.core.domain.Grade;
import park.core.domain.Member;
import park.core.service.discount.DiscountPolicyService;

/**
 * Created by park on 2022/02/13.
 */
public class AllBeanTest {

  @Test
  public void findAllBean() throws Exception {
    //given
    ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class,
        AutoAppConfig.class);

    DiscountService discount = ac.getBean(DiscountService.class);
    Member member = new Member(1L, "userA", Grade.VIP);
    int discountPrice = discount.discount(member, 10000, "fixDiscountPolicyService");
    int discountPrice2 = discount.discount(member, 20000, "rateDiscountPolicyService");

    assertThat(discount).isInstanceOf(DiscountService.class);
    assertThat(discountPrice).isEqualTo(1000);
    assertThat(discountPrice2).isEqualTo(2000);
    


    //when

    //then
  }

  @RequiredArgsConstructor
  static class DiscountService {
    private final Map<String, DiscountPolicyService> policyMap;
    private final List<DiscountPolicyService> policyList;


    public int discount(Member member, int price , String discountCode) {
      DiscountPolicyService discountPolicy = policyMap.get(discountCode);
      return discountPolicy.discount(member,price);
    }
  }

}
