package view;

import lotto.Lotto;

import java.util.List;

public class OutputView {

    public OutputView(List<Lotto> randomLottoList) {
        showGeneratedRandomLotto(randomLottoList);
    }

    private void showGeneratedRandomLotto(List<Lotto> randomLottoList){
        for (Lotto lotto : randomLottoList) {
            System.out.println(lotto);
        }
    }

    public void showTotalCount() {

    }

}
