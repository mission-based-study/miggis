package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.util.Constants;

import java.util.ArrayList;
import java.util.List;


public class LottoMachine {

    public List<Lotto> purchaseLottos(Money amount) {
        int count = amount.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public static Lotto generateLotto(){

         List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER, Constants.LOTTO_COUNT_NUMBER);

         return new Lotto(randomNumbers);
    }

    public LottoResult checkResults(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : purchasedLottos) {
            result.addResult(winningLotto.match(lotto));
        }
        return result;
    }
}
