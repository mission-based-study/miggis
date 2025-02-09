package lotto;

import lotto.domain.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicates(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {

            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public int countMatching(Lotto other) {

        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {

        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }


}
