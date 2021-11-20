package park.core.service;

import park.core.domain.Order;

public interface OrderService {

  Order createOrder(Long memberId, String itemName, int itemPrice);

}
