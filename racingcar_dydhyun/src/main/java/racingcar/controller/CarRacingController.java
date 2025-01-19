package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.LinkedHashSet;
import java.util.List;

public class CarRacingController {
    LinkedHashSet<Car> carLinkedHashSet = new LinkedHashSet<>();
    int gameCount;
    List<Car> winner;
    OutputView outputView;

    public CarRacingController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        initialize(inputView);

        RacingCar racingCar = new RacingCar(carLinkedHashSet);

        for (int i = 0; i < gameCount; i++) {
            racingCar.race();
            outputView.printRaceRound(racingCar.getCars());
        }

        winner = racingCar.getWinners();
        outputView.printWinners(winner);

    }

    private void initialize(InputView inputView) {
        this.carLinkedHashSet = inputView.getCarLinkedHashSet();
        this.gameCount = inputView.getGameCount();
    }

}
