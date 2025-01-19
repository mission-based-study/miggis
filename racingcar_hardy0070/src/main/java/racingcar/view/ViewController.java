package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.Car;

public class ViewController {

    private final InputView input = new InputView();
    private final OutputView output = new OutputView();

    public ViewController() {
    }

    public String initialCarNames() {
        output.printMessage("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return input.readCarNames();
    }

    public List<String> separatedCarNames(String initialCarNames) {
        List<String> separatedCarNames = new ArrayList<>();

        String[] splitCarNames = spiltCarNames(initialCarNames);
        for (String splitCarName : splitCarNames) {
            separatedCarNames.add(splitCarName.trim());
        }

        return separatedCarNames;
    }

    public int getRaceNumber() {
        output.printMessage("시도할 횟수는 몇 회인가요?");
        return input.readRaceNumber();
    }

    private String[] spiltCarNames(String carNames) {
        return carNames.split(",");
    }

}
