package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    OrderService orderService = new OrderService();

    @DisplayName("구입 금액을 로또 회수로 반환한다.")
    @Test
    void convertMoneyToQuantity() {
        int money = 8000;

        int quantity = orderService.convertMoneyToQuantity(money);

        Assertions.assertThat(quantity).isEqualTo(8);
    }

    @DisplayName("구입 금액이 1000원보다 작다면 예외처리를 발생시킨다.")
    @Test
    void throwMinimumException() {
        int money = 900;

        Assertions.assertThatThrownBy(() -> orderService.convertMoneyToQuantity(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 구입 금액은 1000원 입니다.");
    }

    @DisplayName("구입 금액이 1000원 단위가 아니라면 예외처리를 발생시킨다.")
    @Test
    void throwStandardException() {
        int money = 8700;

        Assertions.assertThatThrownBy(() -> orderService.convertMoneyToQuantity(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위 입니다.");
    }

}
