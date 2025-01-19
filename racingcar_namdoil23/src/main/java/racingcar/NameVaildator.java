package racingcar;

import java.util.HashSet;
import java.util.Set;

public class NameVaildator {

    // 중복된 이름을 관리하기 위한 Set
    private static final Set<String> nameSet = new HashSet<>();

    // 이름입력값이 비었는지 확인
    public static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }
    // 이름입력값이 다섯글자가 넘는지 확인
    public static boolean validateNameLength(String name) {
        return name.length() <= 5;
    }

    // 이름을 검증하고 중복 여부를 반환하는 메서드
    public static boolean isNameDuplicate(String name) {
        if (nameSet.contains(name)) {
            return true; // 이미 존재하는 이름
        }
        nameSet.add(name);
        return false;
    }

}
