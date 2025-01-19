package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_이름_5자_이내(){
        // given : 5글자 이름이 주어지고
        String name = "다섯글자야";

        // when : car 객체에 이름을 넣었을 때
        Car car = new Car(name);

        // then : 주어진 이름과 car 객체에 들어간 이름이 같은지
        Assertions.assertThat(car.getName()).isEqualTo(name);
    }
    @Test
    @DisplayName("차이름 6자부터는 에러발생")
    void 자동차_이름_5자_넘으면_에러(){
        // given : 6글자 이름이 주어지고
        String name = "여섯글자에러";
        // when : car 객체에 이름이 들어갔을 때
        // then : 에러가 발생하는지 검증
        Assertions.assertThatThrownBy(() -> new Car(name));
    }

    @Test
    void 자동차는_위치값_갖는다(){
        // given : car 객체를 생성하고
        Car car = new Car("자동차1");
        // when : car 객체가 초기 위치값 0 을 가질때
        // then : 생성한 객체의 position 이 0 인지 검증
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 무작위값_4이상이면_전진(){
        // given : car 객체가 주어짐
        Car car = new Car("자동차1");
        // when : 4 의 값이 주어질때
        car.move(4);
        // then : 객체의 위치값이 +1 인지 검증
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    void 무작위값_4이하면_정지(){
        // given : car 객체 주어짐
        Car car = new Car("자동차1");
        // when : 4이하 값 주어질 때
        car.move(3);
        // then : car 객체의 position 이 변동없이 초기값 0 인지
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

}
