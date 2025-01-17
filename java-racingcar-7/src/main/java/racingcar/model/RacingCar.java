package racingcar.model;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCar {
    private LinkedHashSet<Car> carLinkedHashSet;

    public RacingCar(LinkedHashSet<Car> carLinkedHashSet){
        this.carLinkedHashSet = carLinkedHashSet;
    }


    public void race(int movingCount) {
        for (int i = 0; i < movingCount; i++) {
            for (Car car : carLinkedHashSet) {
                car.move(generateRandomValue());
            }
        }
    }

    public void raceTest(int movingCount, int[] testRandomVal) {
        int index = 0;
        for (int i = 0; i < movingCount; i++) {
            for (Car car : carLinkedHashSet) {
                car.move(testRandomVal[index++]);
            }
        }
    }
    public List<Car> getWinners() {
        int maxPosition = carLinkedHashSet.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("자동차 리스트가 비어 있습니다."));

        // 최고 점수를 가진 모든 자동차를 리스트에 추가
        return carLinkedHashSet.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }



    // TODO: 자동차 경주 객체 RacingCar 에서 난수 생성해주기
    private int generateRandomValue(){
        return (int) Math.floor(Math.random() * 10);
    }

}
