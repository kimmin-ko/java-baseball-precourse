package baseball.controller;

import baseball.domain.BaseballReferee;
import baseball.domain.BaseballResult;
import baseball.domain.BaseballUserOption;
import baseball.domain.BaseballValidator;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.BaseballNumberRule.MIN_NUMBER;
import static baseball.domain.BaseballNumberRule.MAX_NUMBER;
import static baseball.domain.BaseballNumberRule.NUMBER_COUNT;

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
     * 사용자가 정답을 맞추면 사용자의 선택에 따라 게임 재시작 또는 종료한다.
     */
    public void startGame() {
        BaseballUserOption inputBaseballOption;
        do {
            List<Integer> computerNumbers = generateUniqueNumbers();
            compareNumbers(computerNumbers);

            inputBaseballOption = view.requestBaseballOption();
        } while (inputBaseballOption.isRestart());
        view.showEndMessage();
    }

    /**
     * 컴퓨터의 숫자와 사용자의 숫자를 비교하여 결과를 출력한다.
     *
     * @param computerNumbers 컴퓨터가 생성한 숫자
     */
    private void compareNumbers(List<Integer> computerNumbers) {
        BaseballResult result;
        do {
            String inputNumber = view.requestInputNumber();
            BaseballValidator.validate(inputNumber);

            List<Integer> inputNumbers = parseToIntegerList(inputNumber);
            BaseballReferee referee = new BaseballReferee(computerNumbers, inputNumbers);
            referee.judgment();

            result = referee.getResult();
            view.showResult(result);
        } while (result.isNotAnswer());
    }

    /**
     * 중복되지 않은 세 자리 숫자를 생성한다.
     *
     * @return 세자리 숫자
     */
    private List<Integer> generateUniqueNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < NUMBER_COUNT.value())
            uniqueNumbers.add(Randoms.pickNumberInRange(MIN_NUMBER.value(), MAX_NUMBER.value()));
        return new ArrayList<>(uniqueNumbers);
    }

    /**
     * 사용자가 입력한 숫자를 List<Integer>로 파싱한다.
     *
     * @param inputNumber 사용자가 입력한 숫자의 String 타입
     * @return 사용자가 입력한 숫자의 List<Integer> 타입
     */
    private List<Integer> parseToIntegerList(String inputNumber) {
        List<Integer> result = new ArrayList<>();

        String[] inputNumbers = inputNumber.split("");
        for (String number : inputNumbers)
            result.add(Integer.parseInt(number));

        return result;
    }

}