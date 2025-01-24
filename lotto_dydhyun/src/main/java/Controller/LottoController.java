package Controller;

import lotto.Lotto;
import lotto.LottoGame;
import view.InputView;

public class LottoController {

    public void runLottoGame(){
        InputView inputView = new InputView();
        int gameCount = inputView.gameCount;
        LottoGame lottoGame = new LottoGame(gameCount);

        // TODO: OutputView 로 분리해주기
        for (Lotto lotto : lottoGame.randomLottoList) {
            System.out.println(lotto);
        }

        inputView.enterWinningNumber();
        inputView.enterBonusNumber();

    }

}
