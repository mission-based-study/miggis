package lotto;

public class WinLotto {

    private Lotto lotto;
    private int bonusNumber;

    public WinLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    // 추가적인 예외처리 필요함.
    private void validate(int bonusNumber) {
        validateZero(bonusNumber);
    }

    private void validateZero(int bonusNumber) {
        if (bonusNumber == 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }
}
