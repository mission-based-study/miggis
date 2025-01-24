package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = sortNumbers(numbers);
        isDuplicate(sortedNumbers);
        isInRange(sortedNumbers);

        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LOTTO_SIZE + "개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private List<Integer> sortNumbers(List<Integer> numbers){
        return numbers.stream().sorted().toList();
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    private void isInRange(List<Integer> numbers) {
        checkMinimumValue(numbers.getFirst());
        checkMaximumValue(numbers.getLast());
    }

    private void checkMinimumValue(int number) {
        if (number < LOTTO_NUMBER_MIN) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LOTTO_NUMBER_MIN + "부터 " + LOTTO_NUMBER_MAX + "의 값을 가집니다.");
        }
    }

    private void checkMaximumValue(int number) {
        if (number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LOTTO_NUMBER_MIN + "부터 " + LOTTO_NUMBER_MAX + "의 값을 가집니다.");
        }
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
