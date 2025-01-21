package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static int generate(){
        return Randoms.pickNumberInRange(0,9);
    }
}
