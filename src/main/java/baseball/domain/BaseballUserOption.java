package baseball.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 야구 게임 옵션
 *
 * @author : kimmin
 * @since : 2022-04-15 오후 22:38
 */
public enum BaseballUserOption {

    RESTART("1", "게임 재시작"),
    END("2", "게임 종료");

    private final String value;
    private final String label;

    BaseballUserOption(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String value() {
        return value;
    }

    public String label() {
        return label;
    }

    public boolean isRestart() {
        return this.equals(RESTART);
    }

    private static final Map<String, BaseballUserOption> valueOptionMap = new HashMap<>();

    static {
        BaseballUserOption[] options = BaseballUserOption.values();
        for (BaseballUserOption option : options) {
            String key = option.value();
            valueOptionMap.put(key, option);
        }
    }

    /**
     * 사용자가 입력한 값으로 BaseballUserOption 인스턴스를 반환한다.
     * Map에 값이 없을 시 예외를 발생시킨다.
     *
     * @param value 사용자가 입력한 게임 옵션 값
     * @return BaseballUserOption
     */
    public static BaseballUserOption of(String value) {
        if (!valueOptionMap.containsKey(value))
            throw new IllegalArgumentException("사용자가 잘못된 옵션을 입력하였습니다. : " + value);

        return valueOptionMap.get(value);
    }
}
