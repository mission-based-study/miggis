package service;

import Model.Lotto;
import Model.Matched;
import Model.WinLotto;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MatchService {

    public Map<Matched, Integer> getResults(WinLotto winLotto, List<Lotto> userLottos) {
        Map<Matched, Integer> countOfMatched = initializeMatchedValues();

        for (Lotto userLotto : userLottos) {
            Matched matched = winLotto.compareWinLottoAnd(userLotto);
            countOfMatched.put(matched, countOfMatched.get(matched) + 1);
        }

        return countOfMatched;
    }

    private Map<Matched, Integer> initializeMatchedValues() {
        Map<Matched, Integer> countOfMatched = new LinkedHashMap<>();

        Arrays.stream(Matched.values())
                .forEach(value -> countOfMatched.put(value, 0));

        return countOfMatched;
    }
}
