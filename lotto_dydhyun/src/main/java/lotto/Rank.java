package lotto;

public enum Rank {
    FIRST(6, false, "6개 일치 (2,000,000,000원) - ", 2_000_000_000),
    SECOND(5,false, "5개 일치, 보너스 불 일치 (30_000_000원) - ", 30_000_000), // 보너스 불일치
    THIRD(5, true, "5개 일치, (1_500_000원) - ", 1_500_000),
    FOURTH(4, false, "4개 일치 (50,000원) - ", 50000),
    FIFTH(3, false, "3개 일치 (5,000원) - ", 5000),
    NOMATCH(0, false, "3개 이하", 0);

    private final int matchCount;
    private final boolean bonusMatch;
    private final String description;
    private final int prize;

    Rank(int matchCount, boolean bonusMatch, String description, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.description = description;
        this.prize = prize;
    }

}
