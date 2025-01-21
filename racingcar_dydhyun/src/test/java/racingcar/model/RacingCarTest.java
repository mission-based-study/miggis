package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

public class RacingCarTest {

    @Test
    void 자동차경주(){
        Car car1 = new Car("dydhn");
        Car car2 = new Car("wldn");
        Car car3 = new Car("dnqls");
        LinkedHashSet<Car> carLinkedHashSet = new LinkedHashSet<>();
        carLinkedHashSet.add(car1);
        carLinkedHashSet.add(car2);
        carLinkedHashSet.add(car3);

        RacingCar racingCar = new RacingCar(carLinkedHashSet);

        int[] randomValues = {1,3,7,2,5,8,4,6,9};

        racingCar.raceTest(3,randomValues);


        Assertions.assertThat(car3.getPosition()).isGreaterThan(car2.getPosition());
        Assertions.assertThat(car2.getPosition()).isGreaterThan(car1.getPosition());

        Assertions.assertThat(car3).isEqualTo(racingCar.getWinners().getFirst());
    }
    @Test
    void 우승자가_둘_이상일_경우(){
        Car car1 = new Car("dydhn");
        Car car2 = new Car("wldn");
        Car car3 = new Car("dnqls");
        LinkedHashSet<Car> carLinkedHashSet = new LinkedHashSet<>();
        carLinkedHashSet.add(car1);
        carLinkedHashSet.add(car2);
        carLinkedHashSet.add(car3);

        RacingCar racingCar = new RacingCar(carLinkedHashSet);

        int[] randomValues = {0,4,4,0,4,4,0,0,0};

        racingCar.raceTest(3,randomValues);


        Assertions.assertThat(car2.getPosition()).isGreaterThan(car1.getPosition());
        Assertions.assertThat(car3.getPosition()).isGreaterThan(car1.getPosition());

        Assertions.assertThat(car2).isEqualTo(racingCar.getWinners().get(0));
        Assertions.assertThat(car3).isEqualTo(racingCar.getWinners().get(1));
    }


}
