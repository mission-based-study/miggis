package Controller;

import lotto.Counting;
import lotto.Lotto;
import lotto.LottoGame;
import view.InputView;
import view.OutputView;

import java.util.Arrays;

public class LottoController {

    public void runLottoGame(){
        InputView inputView = new InputView();

        int gameCount = inputView.gameCount;
        int purchaseAmount = gameCount * InputView.PURCHASE_SCALE;

        LottoGame lottoGame = new LottoGame(gameCount);

        OutputView outputView = new OutputView(lottoGame.randomLottoList);

        Lotto winningNumber = inputView.enterWinningNumber();
        int bonusNumber = noDuplicationInputBonusNumber(winningNumber, inputView, lottoGame);
        //TODO ->
        Counting counting = new Counting(lottoGame.randomLottoList, winningNumber, bonusNumber);

        int income = outputView.showTotalCount(counting.outputList);

        outputView.showIncomeRate(purchaseAmount, income);

    }

    private int noDuplicationInputBonusNumber(Lotto winningNumber, InputView inputView, LottoGame lottoGame) {
        while (true) {
            int bonusNumber = inputView.enterBonusNumber();

            if (!lottoGame.checkBonusNumberInRange(bonusNumber)) {
                System.out.println("[ERROR] 보너스 번호는 로또 범위에 있어야 합니다. 다시 입력하세요.");
                continue;
            }

            if (!lottoGame.isDuplicateBonusNumberCompareToWinningNumber(winningNumber, bonusNumber)) {
                return bonusNumber;
            }
            System.out.println("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다. 다시 입력하세요.");
        }
    }



}
