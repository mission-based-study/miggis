package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    List<Lotto> randomLottoList;

    public LottoGame(int gameCount) {
        this.randomLottoList = generateLotto(gameCount);

    }

    public List<Lotto> generateLotto(int gameCount) {
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

    // lottoGame 객체와 독립적인 기능이라 생각해 정적 메서드로 변경함.
    public static boolean isDuplicateBonusNumberCompareToWinningNumber(Lotto winningNumber, int bonusNumber) {
        return winningNumber.isDuplicateNumber(bonusNumber);
    }

    public static boolean checkBonusNumberInRange(int bonusNumber) {
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
