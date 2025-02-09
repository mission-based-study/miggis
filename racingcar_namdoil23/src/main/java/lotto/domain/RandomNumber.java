package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class RandomNumber {
    public static Lotto generateLotto(){

        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45, 6));
    }
}
