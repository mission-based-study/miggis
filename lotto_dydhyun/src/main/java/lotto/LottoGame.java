package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public List<Lotto> randomLottoList;

    public LottoGame(int gameCount) {
        this.randomLottoList = generateLotto(gameCount);

    }

    private List<Lotto> generateLotto(int gameCount) {
        List<Lotto> generatedLotto = new ArrayList<>();

        for (int i = 0; i < gameCount; i++) {
            generatedLotto.add(new Lotto(generateRandomNumber()));
        }

        return generatedLotto;
    }

    private List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream().sorted().toList();
    }

    public boolean isDuplicateBonusNumberCompareToWinningNumber(Lotto winningNumber, int bonusNumber) {
        return winningNumber.isDuplicateNumber(bonusNumber);
    }

    public boolean checkBonusNumberInRange(int bonusNumber) {
        try {
            Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

            lotto.checkMinimumValue(bonusNumber);
            lotto.checkMaximumValue(bonusNumber);

            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
