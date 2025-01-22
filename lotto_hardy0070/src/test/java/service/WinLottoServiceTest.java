package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoServiceTest {

    WinLottoService winLottoService = new WinLottoService();

    @DisplayName("문자열을 입력하면 List<Integer>로 반환한다.")
    @Test
    void convertStringToList() {
        String numbers = "1,2,3,4,5,6";

        List<Integer> winLottoNumbers = winLottoService.getWinLotto(numbers);

        Assertions.assertThat(winLottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("공백이 포함된 문자열을 입력해도 에러 발생 없이 반환한다.")
    @Test
    void ignoreSpaceLetter() {
        String numbers = "1, 2,   3    ,  4, 5,    6";

        List<Integer> winLottoNumbers = winLottoService.getWinLotto(numbers);

        Assertions.assertThat(winLottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

}
