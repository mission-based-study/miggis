package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Lotto;
import lotto.WinLotto;
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

    @DisplayName("입력 값으로 당첨 로또를 정하는 기능")
    @Test
    void makeWinLotto() {
        String numbers = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;

        WinLotto winLotto = inputController.decideWinLottoNumbers(numbers, bonusNumber);

        Assertions.assertThat(winLotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
