package Model;

import java.util.Arrays;

//  당첨 로또+보너스와 발행한 로또 번호를 비교하는 기능
// 비교할 기준이 필요함
// Matched가 그 기준이 될 것임
public enum Matched {

    LOOSE_NUMBERS(2, null),
    THREE_NUMBERS(3, "5,000원"),
    FOUR_NUMBERS(4, "50,000원"),
    FIVE_NUMBERS(5, "1,500,000원"),
    FIVE_NUMBERS_AND_BONUS_NUMBER(5, "30,000,000원"),
    SIX_NUMBERS(6, "2,000,000,000원");

    private int matchedNumbers;
    private String prize;

    Matched(int matchedNumbers, String prize) {
        this.matchedNumbers = matchedNumbers;
        this.prize = prize;
    }

    //  비교 로직에서 (맞춘 번호)와 (보너스 번호)를 받고 해당하는 enum 상수 반환하는 기능
    public static Matched matchingPrizeBy(int numberOfMatched, boolean bonusMatched) {
        if (numberOfMatched == 5 && bonusMatched) {
            return FIVE_NUMBERS_AND_BONUS_NUMBER;
        }

        return Arrays.stream(Matched.values())
                .filter(value -> value.matchedNumbers == numberOfMatched)
                .findFirst()
                .orElse(LOOSE_NUMBERS);
    }

}
