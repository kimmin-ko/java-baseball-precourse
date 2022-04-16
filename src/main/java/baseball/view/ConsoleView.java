package baseball.view;

import baseball.domain.BaseballResult;
import baseball.domain.BaseballUserOption;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자에게 게임 안내를 콘솔로 출력하고 필요한 값을 입력받는다.
 *
 * @author : kimmin
 * @since : 2022-04-15 오후 22:31
 */
public class ConsoleView implements View {

    @Override
    public String requestInputNumber() {
        System.out.print("숫자를 입력해 주세요: ");
        return Console.readLine();
    }

    @Override
    public void showResult(BaseballResult result) {
        System.out.println(result);
    }

    @Override
    public BaseballUserOption requestBaseballOption() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return BaseballUserOption.of(Console.readLine());
    }

    @Override
    public void showEndMessage() {
        System.out.println(BaseballUserOption.END.label());
    }
}
