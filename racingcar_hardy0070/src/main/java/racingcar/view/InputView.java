package racingcar.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String readCarNames() {
        return scanner.nextLine();
    }

    public int readRaceNumber() {
        return scanner.nextInt();
    }

}
