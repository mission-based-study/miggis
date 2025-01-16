package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_이름_5자_이내(){
        String name = "다섯글자야";

        Car car = new Car(name);
        Assertions.assertThat(car.getName()).isEqualTo(name);
    }
    @Test
    void 자동차_이름_5자_넘으면_에러(){
        String name = "여섯글자에러";

        Assertions.assertThatThrownBy(() -> new Car(name));
    }

    @Test
    void 자동차는_위치값_갖는다(){
        Car car = new Car("자동차1");

        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 무작위값_4이상이면_전진(){
        Car car = new Car("자동차1");
        car.move(4);

        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    void 무작위값_4이하면_정지(){
        Car car = new Car("자동차1");
        car.move(3);

        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

}
