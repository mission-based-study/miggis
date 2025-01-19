package racingcar.view;

import java.util.List;
import racingcar.Car;

public class OutputView {

    public OutputView() {
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void printCarLocation(Car car) {
        printMessage(car.getCarName() + " : " + convertMoveCount(car.getMoveCount()));
    }

    private String convertMoveCount(int moveCount) {
        String carLocation = "";

        for (int i = 0; i < moveCount; i++) {
            carLocation += "-";
        }

        return carLocation;
    }

    public void printWinnerCars(String winnerCars) {
        printMessage("최종 우승자 : " + winnerCars.substring(0, winnerCars.length() - 2));
    }

    public void printRacingResult(int raceNumber, List<Car> racingCars) {
        System.out.println("실행 결과");
        for (int i = 0; i < raceNumber; i++) {
            for (Car racingCar : racingCars) {
                racingCar.getMoveOrStopVoid();
                printCarLocation(racingCar);
            }
            System.out.println();
        }
    }
}
