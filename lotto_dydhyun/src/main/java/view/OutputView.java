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

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NOMATCH) continue;

            long count = rankCountMap.getOrDefault(rank, 0L);

            System.out.println(rank + "" + count + "개");
        }

        return income;
    }

    public void showIncomeRate(int purchaseAmount, int income){
        double incomeRate = ((double) income / purchaseAmount) * 100;

        System.out.println("총 수익률은 " + incomeRate + "% 입니다.");
    }

}
