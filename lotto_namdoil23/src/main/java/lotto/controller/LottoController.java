package lotto.controller;

import lotto.Lotto;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;


public class LottoController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        try {
            Money purchaseAmount = new Money(inputView.inputPurchaseAmount());
            List<Lotto> purchasedLottos = lottoMachine.purchaseLottos(purchaseAmount);
            resultView.printPurchasedLottos(purchasedLottos);

            Lotto winningLottoNumbers = inputView.inputWinningNumbers();
            int bonusNumberInput = inputView.inputBonusNumber();

            LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);

            WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

            LottoResult result = lottoMachine.checkResults(purchasedLottos, winningLotto);
            resultView.printResults(result);


        }   catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
