package baseball.view;

import baseball.domain.BaseballResult;
import baseball.domain.BaseballUserOption;

/**
 * 사용자에게 게임 안내를 출력하고 필요한 값을 입력받는다.
 *
 * @author : kimmin
 * @since : 2022-04-15 오후 22:30
 */
public interface View {
    String requestInputNumber();
    void showResult(BaseballResult result);
    BaseballUserOption requestBaseballOption();
    void showEndMessage();
}