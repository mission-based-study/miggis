package Model;

import java.util.List;

//      [일급컬렉션]
//      제공된 Lotto 클래스를 사용하여 구현해야 한다.
//        • Lotto에 numbers 이 외의 필드(인스턴스 변수)를 추가할 수 없다.
//        • numbers의 접근 제어자 인 private은 변경할 수 없다.
//        • Lotto의 패키지를 변경할 수 있다.

// 클래스 명세
// 로또 클래스는 로또의 검증을 책임진다.
// 로또와 로또를 비교하는 역할과 책임
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    int countMatchedNumber(Lotto winLotto) {
        int matchedNumber = 0;

        for (Integer userNumber : numbers) {
            matchedNumber += winLotto.compareBetween(winLotto, userNumber);
        }

        return matchedNumber;
    }

    private int compareBetween(Lotto winLotto, Integer userNumber) {
        if (winLotto.containsThis(userNumber)) {
            return 1;
        }

        return 0;
    }

    boolean containsThis(Integer userNumber) {
        return numbers.contains(userNumber);
    }

    // 추가적인 예외처리 필요함.
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    // TODO: 추가 기능 구현

}
