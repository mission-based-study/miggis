package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WinLottoService {

    public List<Integer> getWinLotto(String numbers) {
        String[] splitNumbers = numbers.split(",");

        List<Integer> winLottoNumbers = mapToLottoNumber(splitNumbers);

        return winLottoNumbers;
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
