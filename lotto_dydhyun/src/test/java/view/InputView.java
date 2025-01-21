package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputView {
    @Test
    void 구매_금액은_천원_단위를_갖는다(){
        int coin = 4500;
        Assertions.assertThat(coin);
    }
}
