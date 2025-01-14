package racingcar.view;

public class InputView {
    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_GAME_COUNT = "시도할 회수는 몇회 인가요?";

    private void getCarName(){
        System.out.println(ENTER_CAR_NAME);
        // validate CarName
    }

    public InputView() {

    }
}
