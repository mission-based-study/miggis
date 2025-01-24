package controller;

import java.util.List;
import Model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputControllerTest {

    InputController inputController = new InputController();

    @DisplayName("구입 금액에 맞는 수량만큼 로또를 발행한다.")
    @Test
    void issueLottos() {
        int userPurchase = 8000;

        List<Lotto> lottos = inputController.buyLottos(userPurchase);

        Assertions.assertThat(lottos.size()).isEqualTo(8);
    }

}
