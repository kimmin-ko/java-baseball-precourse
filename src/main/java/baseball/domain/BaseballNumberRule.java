package baseball.domain;

/**
 * 야구 게임 숫자 규칙
 *
 * @author : kimmin
 * @since : 2022-04-16 오후 13:00
 */
public enum BaseballNumberRule {
    MIN_NUMBER(1, "숫자 최솟값"),
    MAX_NUMBER(9, "숫자 최댓값"),
    NUMBER_COUNT(3, "숫자 개수");

    private final int value;
    private final String label;

    public int value() {
        return value;
    }

    public String label() {
        return label;
    }

    BaseballNumberRule(int value, String label) {
        this.value = value;
        this.label = label;
    }
}
