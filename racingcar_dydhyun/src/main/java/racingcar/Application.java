package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        // TODO: 생성자 -> 시작함수 만들기
        CarRacingController controller = new CarRacingController(inputView, outputView);


    }
}
