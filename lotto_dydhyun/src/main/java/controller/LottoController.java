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

        int gameCount = inputPurchaseAmount();
        int purchaseAmount = gameCount * InputView.PURCHASE_SCALE;

        LottoGame lottoGame = new LottoGame();

        List<Lotto> randomLottoList = lottoGame.generateLotto(gameCount);

        outputView.showGeneratedRandomLotto(randomLottoList);

        Lotto winningNumber = inputWinningNumber();
        int bonusNumber = noDuplicationInputBonusNumber(winningNumber);

        Counting counting = new Counting(randomLottoList, winningNumber, bonusNumber);

        int income = outputView.showTotalCount(counting.outputList);

        outputView.showIncomeRate(purchaseAmount, income);

    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                return inputView.purchase();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 입력입니다. 입력은 " + InputView.PURCHASE_SCALE + "원 단위의 숫자만 허용합니다.");
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto inputWinningNumber() {
        while (true) {
            try {
                return inputView.enterWinningNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int noDuplicationInputBonusNumber(Lotto winningNumber) {
        while (true) {
            try {

                int bonusNumber = inputView.enterBonusNumber();

                if (!LottoGame.checkBonusNumberInRange(bonusNumber)) {
                    System.out.println("[ERROR] 보너스 번호는 로또 범위에 있어야 합니다. 다시 입력하세요.");
                    continue;
                }

                if (!LottoGame.isDuplicateBonusNumberCompareToWinningNumber(winningNumber, bonusNumber)) {
                    return bonusNumber;
                }
                System.out.println("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다. 다시 입력하세요.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
