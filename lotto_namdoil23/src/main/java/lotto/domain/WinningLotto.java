package lotto.domain;

import lotto.Lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateBonus(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Prize match(Lotto userLotto) {
        int countOfMatch = lotto.countMatching(userLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);
        return Prize.valueOf(countOfMatch, matchBonus);
    }


}
