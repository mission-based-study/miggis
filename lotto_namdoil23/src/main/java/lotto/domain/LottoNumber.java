package lotto.domain;

import lotto.util.Constants;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        if (number < Constants.LOTTO_MIN_NUMBER || number > Constants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는" + Constants.LOTTO_MIN_NUMBER + "부터" + Constants.LOTTO_MAX_NUMBER + "사이의 숫자여야 합니다.");
        }

        this.number = number;
    }


}
