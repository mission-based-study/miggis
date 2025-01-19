package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Car {

    private String carName;
    private int moveCount;

    public Car(String carName, int moveCount) {
        this.carName = validateLength(carName);
        this.moveCount = moveCount;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void getMoveOrStopVoid() {
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber > 3) {
            moveCount++;
        }
    }

    private String validateLength(String carName) {
        if (carName == "" || carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 입력해주세요.");
        }
        return carName;
    }

}
