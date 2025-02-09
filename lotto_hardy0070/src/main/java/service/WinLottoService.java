package service;

import Model.Lotto;
import Model.WinLotto;
import java.util.ArrayList;
import java.util.List;

public class WinLottoService {

    public WinLotto getWinLotto(String numbers, int bonusNumber) {
        String[] splitNumbers = numbers.split(",");

        Lotto lotto = new Lotto(mapToLottoNumber(splitNumbers));

        return new WinLotto(lotto, bonusNumber);
    }

    private List<Integer> mapToLottoNumber(String[] splitNumbers) {
        List<Integer> winLottoNumbers = new ArrayList<>();

        for (String splitNumber : splitNumbers) {
            int lottoNumber = mapToSingleLottoNumber(splitNumber);

            winLottoNumbers.add(lottoNumber);
        }

        return winLottoNumbers;
    }

    private int mapToSingleLottoNumber(String splitNumber) {
        String trimmedNumber = splitNumber.trim();

        return Integer.parseInt(trimmedNumber);
    }
}
