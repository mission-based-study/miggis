package service;

public class OrderService {

    public int convertMoneyToQuantity(int money) {
        validate(money);

        return money / 1000;
    }

    private void validate(int money) {
        validateMinimumPrice(money);
        validateBuyStandards(money);
    }

    private void validateMinimumPrice(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1000원 입니다.");
        }
    }

    private void validateBuyStandards(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위 입니다.");
        }
    }
}
