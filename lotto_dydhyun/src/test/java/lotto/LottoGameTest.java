package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoGameTest {

    @Test
    void 입력에_따른_로또_생성_개수_테스트(){
        // given
        LottoGame lottoGame = new LottoGame();
        int gameCount = 3;

        // when
        List<Lotto> randomLottoList = lottoGame.generateLotto(gameCount);

        // then
        Assertions.assertThat(randomLottoList.size()).isEqualTo(gameCount);
    }

    @Test
    void 보너스_번호와_로또_번호의_중복_테스트(){
        // given
        Lotto winningNumber = new Lotto(List.of(1,2,3,4,5,6));

        // when
        int duplicateBonusNumber = 6;
        int noDuplicateBonusNumber = 7;

        // then
        Assertions.assertThat(LottoGame.isDuplicateBonusNumberCompareToWinningNumber(winningNumber,duplicateBonusNumber))
                .isEqualTo(true);

        Assertions.assertThat(LottoGame.isDuplicateBonusNumberCompareToWinningNumber(winningNumber,noDuplicateBonusNumber))
                .isEqualTo(false);
    }

    @Test
    void 보너스_번호가_로또_범위를_갖는지(){
        // given
        boolean[] boundaryTestValue = new boolean[5];

        // when
        boundaryTestValue[0] = LottoGame.checkBonusNumberInRange(0);
        boundaryTestValue[1] = LottoGame.checkBonusNumberInRange(1);

        boundaryTestValue[2] = LottoGame.checkBonusNumberInRange(23);

        boundaryTestValue[3] = LottoGame.checkBonusNumberInRange(45);
        boundaryTestValue[4] = LottoGame.checkBonusNumberInRange(46);

        // then
        Assertions.assertThat(boundaryTestValue[0]).isEqualTo(false);
        Assertions.assertThat(boundaryTestValue[1]).isEqualTo(true);
        Assertions.assertThat(boundaryTestValue[2]).isEqualTo(true);
        Assertions.assertThat(boundaryTestValue[3]).isEqualTo(true);
        Assertions.assertThat(boundaryTestValue[4]).isEqualTo(false);
    }

}
