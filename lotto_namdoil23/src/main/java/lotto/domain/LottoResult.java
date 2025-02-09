package lotto.domain;

import lotto.Lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> result = new HashMap<>();

    public LottoResult() {
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
    }

    public void addResult(Prize prize) {
        result.put(prize, result.get(prize) + 1);
    }

    public Map<Prize, Integer> getResult() {
        return result;
    }
}
