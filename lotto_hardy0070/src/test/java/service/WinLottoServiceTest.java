package service;

import static org.junit.jupiter.api.Assertions.*;

import Model.WinLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoServiceTest {

    WinLottoService winLottoService = new WinLottoService();

    @DisplayName("사용자에게 문자열과 보너스 번호를 받아 당첨 로또를 생성한다.")
    @Test
    void getWinLottoTest() {
        String numbers = "1, 2,    3,   4   ,5 , 6";
        int bonusNumber = 7;

        WinLotto winLotto = winLottoService.getWinLotto(numbers, bonusNumber);

//        winLotto
    }
}
