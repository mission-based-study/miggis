package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {
    public static int inputCount() {
        try {
            String input = Console.readLine().trim();
            int count = Integer.parseInt(input); // 정수로 변환

            // 입력값이 0보다 큰지 검증
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
            }

            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }
}
