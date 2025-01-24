package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.util.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public int inputPurchaseAmount() {
        System.out.println(Constants.INPUT_PURCHASE_AMOUNT);
        return Integer.parseInt(Console.readLine());
    }

    public Lotto inputWinningNumbers() {
        System.out.println(Constants.INPUT_WINNING_NUMBERS);
        List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public int inputBonusNumber() {
        System.out.println(Constants.INPUT_BOUNS_NUMBERS);
        return Integer.parseInt(Console.readLine());
    }
}
