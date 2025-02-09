package view;

import lotto.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputViewTest {
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView(List.of());  // 빈 리스트로 생성자 실행
    }

    @Test
    void showTotalCount_수익금_계산_테스트() {
        List<Rank> outputList = List.of(Rank.FIRST, Rank.SECOND, Rank.SECOND, Rank.THIRD, Rank.THIRD, Rank.THIRD, Rank.FOURTH);

        int expectedIncome = Rank.FIRST.getPrize() +
                Rank.SECOND.getPrize() * 2 +
                Rank.THIRD.getPrize() * 3 +
                Rank.FOURTH.getPrize();

        int actualIncome = outputView.showTotalCount(outputList);

        Assertions.assertEquals(expectedIncome, actualIncome);
    }

    @Test
    void getIncomeRate_수익률_테스트() {
        String result = outputView.getIncomeRate(10000, 5000);
        Assertions.assertEquals("총 수익률은 50.0% 입니다.", result);

        result = outputView.getIncomeRate(20000, 22000);
        Assertions.assertEquals("총 수익률은 110.0% 입니다.", result);

        result = outputView.getIncomeRate(8000, 5000);
        Assertions.assertEquals("총 수익률은 62.5% 입니다.", result);
    }

}
