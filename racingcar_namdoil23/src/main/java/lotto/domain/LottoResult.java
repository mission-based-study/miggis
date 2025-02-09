package lotto.domain;

import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Lotto winningLotto;

    private final int bonusNumber;

    private final List<Lotto> purchasedLottos;

    public LottoResult(Lotto winningLotto, int bonusNumber, List<Lotto> purchasedLottos) {

        this.winningLotto = winningLotto;

        this.bonusNumber = bonusNumber;

        this.purchasedLottos = purchasedLottos;
    }

    public Map<Prize, Integer> calculateResults(){
        Map<Prize, Integer> result = new HashMap<>();

        for (Lotto lotto : purchasedLottos) {

            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();

            boolean hasBonus  = lotto.getNumbers().contains(bonusNumber);

            Prize prize = Prize.valueOfMatchCount(matchCount,hasBonus);
            result.put(prize, result.getOrDefault(prize, 0) + 1);
        }

        return result;


    }
}
