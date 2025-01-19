package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

class InputViewTest {

    OutputView outputView = new OutputView();
    ViewController viewController = new ViewController();


    @DisplayName("자동차 이름이 5글자 이하일 때 정상적으로 반환한다.")
    @Test
    void validateCarNameLength() {

        List<String> validatedCarNames = viewController.separatedCarNames("poni, heaby, kate");

        assertThat(validatedCarNames).containsExactly("poni", "heaby", "kate");
    }

    @DisplayName("자동차 이름이 5글자 이상일 때 예외처리 메세지를 반환한다.")
    @Test
    void validateCarNameLengthException() {

        String containOver5 = ("poni, heabyy, kate");

        assertThatThrownBy(() -> viewController.separatedCarNames(containOver5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자 이하로 입력해주세요.");
    }

}
