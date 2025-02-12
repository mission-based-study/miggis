package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final int PURCHASE_SCALE = 1000;

    private int gameCount = 0;

    public InputView(){

    }

    InputView(String userInput) {
        purchaseTest(userInput);

        System.out.println(gameCount + "개를 구매했습니다.");
    }

    private void purchaseTest(String userInput){
        int purchaseAmount = validateInputType(userInput);

        validateInputPositiveNumber(purchaseAmount);
        validateInputScale(purchaseAmount);

        this.gameCount = purchaseAmount / PURCHASE_SCALE;
    }

    public int purchase(){
        System.out.println(ENTER_PURCHASE_AMOUNT);

        String userInput = Console.readLine();

        int purchaseAmount = validateInputType(userInput);

        validateInputPositiveNumber(purchaseAmount);
        validateInputScale(purchaseAmount);

        int gameCount = purchaseAmount / PURCHASE_SCALE;

        System.out.println(gameCount + "개를 구매했습니다.");

        return gameCount;
    }

    private int validateInputType(String userInput){
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }

        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외 입력은 허용하지 않습니다.");
        }
    }

    private void validateInputPositiveNumber(int userInput){
        if (userInput < 1){
            throw new IllegalArgumentException("[ERROR] 입력 금액은 0보다 커야됩니다.");
        }
    }

    private void validateInputScale(int userInput) {
        if (userInput % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력단위는 " + PURCHASE_SCALE + "원 입니다.");
        }
    }

    public Lotto enterWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> winningNumbers = parseInputToList(Console.readLine());

        return new Lotto(winningNumbers);
    }

    private List<Integer> parseInputToList(String rawInput){
//        List<Integer> winningNumber = new ArrayList<>();
//
//        String[] splitInput = rawInput.split(",");
//
//
//        for (String userInputNumber : splitInput) {
//            validateInputType(userInputNumber);
//
//            winningNumber.add(Integer.parseInt(userInputNumber.trim()));
//        }
//
//        return winningNumber.stream().sorted().toList();
        return Arrays.stream(rawInput.split(","))
                .map(String::trim)
                .map(this::validateInputType)
                .sorted()
                .toList();
    }

    public int enterBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");

        String bonusNumber = Console.readLine();

        validateInputType(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }


}
