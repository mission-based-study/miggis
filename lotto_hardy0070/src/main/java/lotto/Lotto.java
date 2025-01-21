package lotto;

import java.util.List;

//      [일급컬렉션]
//      제공된 Lotto 클래스를 사용하여 구현해야 한다.
//        • Lotto에 numbers 이 외의 필드(인스턴스 변수)를 추가할 수 없다.
//        • numbers의 접근 제어자 인 private은 변경할 수 없다.
//        • Lotto의 패키지를 변경할 수 있다.

// 클래스 명세
// 로또 클래스는 로또의 검증을 책임진다.
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
