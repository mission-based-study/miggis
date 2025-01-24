package service;

import java.util.List;
import Model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @DisplayName("주어진 로또 수량만큼 로또를 생성한다.")
    @Test
    void getLottosAsMuchQuantity() {
        List<Lotto> lottos = lottoService.getLottos(8);

        Assertions.assertThat(lottos.size()).isEqualTo(8);
    }

    @DisplayName("발행된 로또는 오름차순으로 정리 되어야한다.")
    @Test
    void lottoValueAscendingTest() {
        List<Lotto> lottos = lottoService.getLottos(5);

        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(0);

            List<Integer> lottoNumbers = lotto.getNumbers();

            Assertions.assertThat(lottoNumbers).isSorted();
        }
    }

}
