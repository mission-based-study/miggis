package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void isDuplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.contains(i)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
            }
        }
    }

}
