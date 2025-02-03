package controller;

import lotto.Counting;
import lotto.Lotto;
import lotto.LottoGame;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runLottoGame(){

        int gameCount = inputView.purchase();
        int purchaseAmount = gameCount * InputView.PURCHASE_SCALE;

        LottoGame lottoGame = new LottoGame(gameCount);

        List<Lotto> randomLottoList = lottoGame.generateLotto(gameCount);

        outputView.showGeneratedRandomLotto(randomLottoList);

        Lotto winningNumber = inputView.enterWinningNumber();
        int bonusNumber = noDuplicationInputBonusNumber(winningNumber);

        Counting counting = new Counting(lottoGame.generateLotto(gameCount), winningNumber, bonusNumber);

        int income = outputView.showTotalCount(counting.outputList);

        outputView.showIncomeRate(purchaseAmount, income);

    }

    private int noDuplicationInputBonusNumber(Lotto winningNumber) {
        while (true) {
            int bonusNumber = inputView.enterBonusNumber();

            if (!LottoGame.checkBonusNumberInRange(bonusNumber)) {
                System.out.println("[ERROR] 보너스 번호는 로또 범위에 있어야 합니다. 다시 입력하세요.");
                continue;
            }

            if (!LottoGame.isDuplicateBonusNumberCompareToWinningNumber(winningNumber, bonusNumber)) {
                return bonusNumber;
            }
            System.out.println("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다. 다시 입력하세요.");
        }
    }


}
