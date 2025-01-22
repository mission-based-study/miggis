package lotto;

import java.util.List;

public class WinLotto {

    private List<Integer> numbers;
    private int bonusNumber;

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    // 추가적인 예외처리 필요함.
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
