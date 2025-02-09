package lotto.view;

import lotto.Lotto;
import lotto.util.Constants;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printPurchasedLotto(List<Lotto> lottos) {

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResults(Map<Prize, Integer> result, int purchaseAmount) {
        System.out.println(Constants.);

        int totalProfit = 0;

        for (Map.Entry<Prize, Integer> entry : result.entrySet()) {
            Prize prize = entry.getKey();

            int count = entry.getValue();

            System.out.println();

            totalProfit += count * prize.getReward();
        }

        double profitRatio = (double) totalProfit / purchaseAmount;
        System.out.println(Constants.,profitRatio);
    }

}
