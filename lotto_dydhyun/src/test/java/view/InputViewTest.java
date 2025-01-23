package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class InputViewTest {
    @Test
    void 구매_금액은_천원_단위를_갖는다(){
        String userInput = "4500";

        Assertions.assertThatThrownBy(() -> new InputView(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력단위는");;
    }

    @Test
    void 구매_금액이_문자가_아니면_예외(){
        String userInput = "userInput";

        Assertions.assertThatThrownBy(() -> new InputView(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외 입력은 허용하지 않습니다.");
    }

    @Test
    void 구매_금액이_비어있다면_예외(){
        String userInput = null;

        Assertions.assertThatThrownBy(() -> new InputView(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값이 비어있습니다.");
    }

    @Test
    void 입력값이_음수면_예외를_던진다() {
        String userInput = "-1000";

        Assertions.assertThatThrownBy(() -> new InputView(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


}
