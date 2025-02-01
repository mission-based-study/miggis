package view;

import lotto.Lotto;
import lotto.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public OutputView(List<Lotto> randomLottoList) {
        showGeneratedRandomLotto(randomLottoList);
    }

    private void showGeneratedRandomLotto(List<Lotto> randomLottoList){
        for (Lotto lotto : randomLottoList) {
            System.out.println(lotto);
        }
    }

    public int showTotalCount(List<Rank> outputList) {
        System.out.println("당첨 통계");

        Map<Rank, Long> rankCountMap = outputList.stream()
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));

        int income = rankCountMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue().intValue())
                .sum();

        printOutputReverse(rankCountMap);

        return income;
    }

    private void printOutputReverse(Map<Rank, Long> rankCountMap){
        Rank[] ranks = Rank.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            Rank rank = ranks[i];
            if (rank == Rank.NOMATCH) continue;

            long count = rankCountMap.getOrDefault(rank, 0L);
            System.out.println(rank + " " + count + "개");
        }
    }

    String getIncomeRate(int purchaseAmount, int income) {
        double incomeRate = ((double) income / purchaseAmount) * 100;
        double roundedIncomeRate = Math.round(incomeRate * 100) / 100.0;

        return "총 수익률은 " + roundedIncomeRate + "% 입니다.";
    }

    public void showIncomeRate(int purchaseAmount, int income) {
        System.out.println(getIncomeRate(purchaseAmount, income));
    }

}
