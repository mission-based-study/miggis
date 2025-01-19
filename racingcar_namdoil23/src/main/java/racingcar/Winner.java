package racingcar;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Winner {
    public static List<String> champoin(Map<String, StringBuilder> carResults) {
        int MaxScore = 0;
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, StringBuilder> entry : carResults.entrySet()) {
            int score = entry.getValue().length(); // "-" 개수 계산
            if (score > MaxScore) {
                MaxScore = score;
                winners.clear(); // 기존 우승자 목록 초기화
                winners.add(entry.getKey());
            } else if (score == MaxScore) {
                winners.add(entry.getKey()); // 동점자 추가
            }
        }
        return winners;
    }

}
