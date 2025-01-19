package racingcar.controller;

import racingcar.model.NameVaildator;
import racingcar.model.RandomNumber;
import racingcar.model.Winner;
import racingcar.view.InputName;
import racingcar.view.InputNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameController {
    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 (,)을 기준으로 구분)");
        String nameInput = InputName.inputCarName();
        // 입력 문자열을 구분자(쉼표)로 분리
        String[] carNames = nameInput.split(",");

        // 이름 검증
        List<String> validCarNames = new ArrayList<>();
        for (String carName : carNames) {
            carName = carName.trim();
            if (NameVaildator.validateName(carName) && NameVaildator.validateNameLength(carName)) {
                if (!NameVaildator.isNameDuplicate(carName)) {
                    validCarNames.add(carName);
                } else {
                    throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다. :" + carName);
                }
            } else {
                throw new IllegalArgumentException("유효하지 않은 이름입니다. :" + carName);
            }
        }

        // 유효한 자동차 이름 출력
        System.out.println("유효한 자동차 이름: " + String.join(", ", validCarNames));

        // 시도할 횟수 입력
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = InputNumber.inputCount();
        System.out.println("시도 횟수: " + tryCount);

        // 각 이름에 대해 결과 저장
        Map<String, StringBuilder> carResults = new HashMap<>();
        for (String carName : validCarNames) {
            carResults.put(carName, new StringBuilder()); // 초기 결과는 빈 문자열
        }

        // 시도 횟수만큼 실행
        for (int i = 0; i < tryCount; i++) {
            for (String carName : validCarNames) {
                int randomNumber = RandomNumber.generate();
                if (randomNumber >= 4) {
                    carResults.get(carName).append("-"); // 숫자가 4 이상이면 "-" 추가
                }
            }
        }

        // 결과 출력
        for (Map.Entry<String, StringBuilder> entry : carResults.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        List<String> winners = Winner.champoin(carResults);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
