package baseball.controller;

import baseball.domain.BaseballReferee;
import baseball.domain.BaseballResult;
import baseball.domain.BaseballValidator;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.BaseballOption.*;

/**
 * 게임 컨트롤러
 *
 * @author : kimmin
 * @since : 2022-04-14 오후 22:-02
 */
public class GameController {

    private final View view;

    public GameController(View view) {
        this.view = view;
    }

    /**
     * 야구 게임을 시작한다.
     */
    public void startGame() {
        List<Integer> computerNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);

        String inputNumber;
        do {
            inputNumber = view.requestInputNumber();
            BaseballValidator.validate(inputNumber);

            List<Integer> inputNumbers = splitToIntegerList(inputNumber);

            BaseballReferee referee = new BaseballReferee(computerNumbers, inputNumbers);
            referee.judgment();

            BaseballResult result = referee.getResult();
            view.printResult(result);

        } while (true);
    }

    /**
     * 사용자가 입력한 숫자를 List<Integer>로 파싱한다.
     *
     * @param inputNumber 사용자가 입력한 숫자의 String 타입
     * @return 사용자가 입력한 숫자의 List<Integer> 타입
     */
    private List<Integer> splitToIntegerList(String inputNumber) {
        List<Integer> result = new ArrayList<>();

        String[] inputNumbers = inputNumber.split("");
        for (String number : inputNumbers)
            result.add(Integer.parseInt(number));

        return result;
    }

}