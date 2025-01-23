package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public LottoGame() {

    }

    List<Lotto> generateLotto(int gameCount) {
        List<Lotto> generatedLotto = new ArrayList<>();

        for (int i = 0; i < gameCount; i++){
            generatedLotto.add(new Lotto(generateRandomNumber()));
        }

        return generatedLotto;
    }

    private List<Integer> generateRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(1,45,6)
                .stream().sorted().toList();
    }

}
