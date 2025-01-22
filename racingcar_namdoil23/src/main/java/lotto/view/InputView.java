package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.List;
import java.util.ArrayList;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println(.PURCHASE_AMOUNT.getMessage());

        return Integer.parseInt(Console.readLine());
    }

    public static List<Lotto> getPurchasedLottos(int purchaseAmount) {
        System.out.println();

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseAmount / 1000; i++) {
            lottos.add();
        }

        return lottos;
    }

    public static Lotto getWinningNumbers() {
        System.out.println(.WINNING_NUMBERS.getMessage());

        String[] numbers = Console.readLine().split(",");

        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }

        return new Lotto(winningNumbers);
    }

    public static int getBonusNumber(){
        System.out.println(.BONUS_NUMBERS.getMessage());

        return Integer.parseInt(Console.readLine());
    }
}
