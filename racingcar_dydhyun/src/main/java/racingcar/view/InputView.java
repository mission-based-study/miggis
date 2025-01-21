package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class InputView {
    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_GAME_COUNT = "시도할 회수는 몇회 인가요?";
    private static final String DELIMITER = ",";

    LinkedHashSet<Car> carLinkedHashSet = new LinkedHashSet<>();
    int gameCount;

    public LinkedHashSet<Car> getCarLinkedHashSet() {
        return carLinkedHashSet;
    }
    public int getGameCount() {
        return gameCount;
    }



    private LinkedHashSet<Car> getCarSet(){
        System.out.println(ENTER_CAR_NAME);

        String input = Console.readLine();
        Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .forEach(name -> carLinkedHashSet.add(new Car(name)));

        return carLinkedHashSet;
    }

    private int enterGameCount(){
        System.out.println(ENTER_GAME_COUNT);

        return Integer.parseInt(Console.readLine());
    }


    public InputView() {
        this.carLinkedHashSet = getCarSet();
        this.gameCount = enterGameCount();
    }
}
