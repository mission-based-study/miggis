package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoGameTest {

    @Test
    void 입력에_따른_로또_생성_개수_테스트(){
        int gameCount = 3;
        LottoGame lottoGame = new LottoGame(gameCount);

//        List<Lotto> randomLottoList = lottoGame.generateLotto(gameCount);

//        Assertions.assertThat(randomLottoList.size()).isEqualTo(gameCount);
    }

}
