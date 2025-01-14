package racingcar.model;

public class Car {

    private String carName;
    private int currentPosition;

    private Car(String carName, int currentPosition){
        // validateCarName 넣어주기
        this.carName = carName;
        this.currentPosition = currentPosition;
    }

}
