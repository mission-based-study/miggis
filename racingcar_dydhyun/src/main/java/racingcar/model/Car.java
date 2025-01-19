package racingcar.model;

public class Car {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int INITIAL_POSITION = 0;
    private static final int MOVING_CONDITION = 4;
    private static final int MOVE_FORWARD = 1;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;

        if (name.length() > MAXIMUM_NAME_LENGTH){
            throw new IllegalArgumentException("차량 이름의 길이는 최대 " + MAXIMUM_NAME_LENGTH + "자 입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


    protected void move(int randomValue){
        if (randomValue >= MOVING_CONDITION) {
            this.position += MOVE_FORWARD;
        }
    }


}
