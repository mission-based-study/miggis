package view;

import lotto.Lotto;
import lotto.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public OutputView(){

    }

    OutputView(List<Lotto> randomLottoList) {
        showGeneratedRandomLotto(randomLottoList);
    }

    public void showGeneratedRandomLotto(List<Lotto> randomLottoList){
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
    // 해당 메서드는 outputList 에 담긴 값으로 수익을 계산하는 메서드 이므로,
    // 출력을 담당하는 View 클래스 보다 Counting 클래스에서 책임지는게 더 적합할듯.

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

        return String.format("총 수익률은 %.2f%% 입니다.",incomeRate);
    }

    public void showIncomeRate(int purchaseAmount, int income) {
        System.out.println(getIncomeRate(purchaseAmount, income));
    }

}
