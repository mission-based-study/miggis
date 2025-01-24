package Model;

// 당첨 로또를 찾는 역할과 책임
public class WinLotto {

    private Lotto lotto;
    private int bonusNumber;

    public WinLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Matched compareWinLottoAnd(Lotto userLotto) {
        int numberOfMatched = userLotto.countMatchedNumber(lotto);

        boolean bonusMatched = userLotto.containsThis(bonusNumber);

        return Matched.matchingPrizeBy(numberOfMatched, bonusMatched);
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
