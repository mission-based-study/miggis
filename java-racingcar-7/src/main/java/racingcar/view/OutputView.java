package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void printRaceRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void printWinners(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder("최종 우승자 : ");
        for (Car winner : winners) {
            winnerNames.append(winner.getName()).append(", ");
        }
        // 우승자 출력시 마지막 쉼표와 공백 제거
        if (!winnerNames.isEmpty()) {
            winnerNames.setLength(winnerNames.length() - 2);
        }
        System.out.println(winnerNames);
    }

}
