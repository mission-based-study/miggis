import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private String getUserValue() {
        return Console.readLine();
    }

    public int getRoundNumber() {
        return Integer.parseInt(getUserValue());
    }

    public String getCarNames() {
        return getUserValue();
    }

    private String validateLength(String carNames) {
        if (!(carNames.length() <= 5)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }

        return carNames;
    }

    private void validate(String[] separatedCarNames) {
        for (String separatedCarName : separatedCarNames) {
            validateLength(separatedCarName);
        }
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }

    private String[] removeSpaceLetter(String[] carNames) {
        String[] removedCarNames = new String[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            removedCarNames[i] = carNames[i].trim();
        }

        return removedCarNames;
    }

    public String[] findCarNames(String carNames) {
        String[] separatedCarNames = removeSpaceLetter(splitCarNames(carNames));
        validate(separatedCarNames);

        return separatedCarNames;
    }

}
