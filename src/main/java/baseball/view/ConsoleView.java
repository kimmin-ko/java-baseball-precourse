package baseball.view;

import baseball.domain.BaseballResult;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleView implements View {

    @Override
    public String requestInputNumber() {
        System.out.print("숫자를 입력해 주세요: ");
        return Console.readLine();
    }

    @Override
    public void printResult(BaseballResult result) {
        System.out.println(result);
    }
}
