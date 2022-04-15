package baseball.view;

import baseball.domain.BaseballResult;

public interface View {
    String requestInputNumber();

    void printResult(BaseballResult result);

}