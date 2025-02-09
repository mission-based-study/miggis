package lotto.view;

import lotto.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Prize;
import lotto.util.Constants;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + Constants.GET_PURCHASE_LOTTO);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResults(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Prize, Integer> resultMap = result.getResult();
        for (Prize prize : Prize.values()) {
            System.out.println(prize + " : " + resultMap.get(prize) + "개");
        }
    }
}

