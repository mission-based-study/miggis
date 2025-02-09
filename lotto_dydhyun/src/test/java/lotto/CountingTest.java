package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CountingTest {

    @Test
    void 당첨번호와_비교해_로또_결과_등수_분류(){
        // given
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));

        int bonusNumber = 7;

        List<Lotto> randomLottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등 (6개 일치)
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),  // 2등 (5개 일치)
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 3등 (5개 + 보너스 일치)
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),  // 4등 (4개 일치)
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),  // 5등 (3개 일치)
                new Lotto(List.of(11, 12, 13, 14, 15, 16))  // 불일치
        );

        // when
        Counting counting = new Counting(randomLottoList, winningLotto, bonusNumber);

        // then
        Assertions.assertThat(counting.outputList.get(0)).isEqualTo(Rank.FIRST);
        Assertions.assertThat(counting.outputList.get(1)).isEqualTo(Rank.SECOND);
        Assertions.assertThat(counting.outputList.get(2)).isEqualTo(Rank.THIRD);
        Assertions.assertThat(counting.outputList.get(3)).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(counting.outputList.get(4)).isEqualTo(Rank.FIFTH);
        Assertions.assertThat(counting.outputList.get(5)).isEqualTo(Rank.NOMATCH);

        List<Rank> expectedRanks = List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.NOMATCH);

        Assertions.assertThat(counting.outputList).isEqualTo(expectedRanks);

    }

}
