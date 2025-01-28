package lotto;

import java.util.ArrayList;
import java.util.List;

public class Counting {

    public final List<Rank> outputList = new ArrayList<>();

    public Counting(List<Lotto> randomLottoList, Lotto winningNumber, int bonusNumber) {
        // TODO: randomLottoList 첫 번째 리스트부터 마지막까지 순회하며 compare메서드 동작하기

        for (int list = 0; list < randomLottoList.size(); list++){
            Rank rank = compareLotto(randomLottoList.get(list), winningNumber, bonusNumber);
            outputList.add(rank);
        }

    }

    private Rank compareLotto(Lotto randomLotto, Lotto winningNumber, int bonusNumber){
        // TODO: randomLotto 와 winningNumber 비교하는 메서드 만들기.
        int matchingCount = randomLotto.countMatchingNumbers(winningNumber);
        int matchingBonus = randomLotto.matchingBonusNumber(bonusNumber);

        return Rank.findRank(matchingCount, matchingBonus);
    }

}
