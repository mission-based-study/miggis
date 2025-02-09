package lotto.domain;

import lotto.util.Constants;

public class Money {
    private int amount;

    public Money(int amount) {

        if(amount < Constants.LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 금액은 " + Constants.LOTTO_PRICE+ "원 이상이어야 합니다.");
        }
        if(amount % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은" + Constants.LOTTO_PRICE+"원 단위입니다.");
        }
        this.amount = amount;
    }

    public int getLottoCount() {
        return amount / Constants.LOTTO_PRICE;
    }

}
