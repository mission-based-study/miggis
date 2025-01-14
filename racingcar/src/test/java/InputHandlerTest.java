import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    InputHandler inputHandler = new InputHandler();

    @DisplayName("문자열을 쉼표로 구분하고 5글자 이하일 때 반환하다.")
    @Test
    void findCarNames() {
        String carNames = "popo, coco, tobi";

        Assertions.assertThat(inputHandler.findCarNames(carNames)).containsExactly("popo", "coco", "tobi");
    }
}
