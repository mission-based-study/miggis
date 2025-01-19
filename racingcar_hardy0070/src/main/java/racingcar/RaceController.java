package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.view.OutputView;
import racingcar.view.ViewController;

public class RaceController {

    private OutputView outputView = new OutputView();
    private ViewController viewController = new ViewController();

    public void racingStart() {
        List<Car> racingCars = createRacingCars(findCarNames());

        outputView.printRacingResult(viewController.getRaceNumber(), racingCars);

        int maxNumber = findMaxNumber(racingCars);

        String winnerCars = findWinnerCars(racingCars, maxNumber);

        outputView.printWinnerCars(winnerCars);
    }

    public List<String> findCarNames() {
        return viewController.separatedCarNames(viewController.initialCarNames());
    }


    public String findWinnerCars(List<Car> racingCars, int maxNumber) {
        String winnerCars = "";

        for (Car racingCar : racingCars) {
            if (racingCar.getMoveCount() == maxNumber) {
                winnerCars += racingCar.getCarName() + ", ";
            }
        }
        return winnerCars;
    }

    public int findMaxNumber(List<Car> racingCars) {
        int maxNumber = 0;

        for (Car racingCar : racingCars) {
            if (racingCar.getMoveCount() > maxNumber) {
                maxNumber = racingCar.getMoveCount();
            }
        }
        return maxNumber;
    }

    public List<Car> createRacingCars(List<String> carNames) {
        List<Car> racingCars = new ArrayList<>();
        validateDuplication(carNames);

        for (String name : carNames) {
            Car car = new Car(name, 0);
            racingCars.add(car);
        }

        return racingCars;
    }

    // 이름 중복검사를 어디에서 책임져야하는가?
    private void validateDuplication(List<String> carNames) {
        Set<String> checkDuplication = new HashSet<>();

        for (String carName : carNames) {
            if (!checkDuplication.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

}
