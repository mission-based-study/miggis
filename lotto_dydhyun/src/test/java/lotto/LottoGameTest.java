package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoGameTest {

    @Test
    void 입력에_따른_로또_생성_개수_테스트(){
        LottoGame lottoGame = new LottoGame();
        int gameCount = 3;

        List<Lotto> generatedLottoList = lottoGame.generateLotto(gameCount);

        Assertions.assertThat(generatedLottoList.size()).isEqualTo(gameCount);
    }


}
