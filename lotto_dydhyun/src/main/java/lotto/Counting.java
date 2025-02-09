package lotto;

import java.util.ArrayList;
import java.util.List;

public class Counting {

    public final List<Rank> outputList = new ArrayList<>();

    public Counting(List<Lotto> randomLottoList, Lotto winningNumber, int bonusNumber) {

        for (Lotto lotto : randomLottoList) {
            Rank rank = compareLotto(lotto, winningNumber, bonusNumber);
            outputList.add(rank);
        }

    }

    private Rank compareLotto(Lotto randomLotto, Lotto winningNumber, int bonusNumber){
        int matchingCount = randomLotto.countMatchingNumbers(winningNumber);
        int matchingBonus = randomLotto.matchingBonusNumber(bonusNumber);

        return Rank.findRank(matchingCount, matchingBonus);
    }

}
