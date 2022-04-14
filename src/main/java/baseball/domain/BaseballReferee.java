package baseball.domain;

import java.util.HashSet;
import java.util.List;

/**
 * 컴퓨터의 숫자와 사용자가 입력한 숫자를 비교하는 심판
 *
 * @author : kimmin
 * @since : 2022-04-14 오후 21:48
 */
public class BaseballReferee {
    public static final int SUM_NUMBERS_LENGTH = 6;

    private final List<Integer> computerNumbers;
    private final List<Integer> inputNumbers;
    private final BaseballResult result;

    public BaseballReferee(List<Integer> computerNumbers, List<Integer> inputNumbers) {
        this.computerNumbers = computerNumbers;
        this.inputNumbers = inputNumbers;
        this.result = new BaseballResult();
    }

    /**
     * 컴퓨터의 숫자와 사용자가 입력한 숫자가 총 몇 개 겹치는지 판단한다.
     * 컴퓨터의 숫자와 사용자가 입력한 숫자중 스트라이크 개수가 몇 개 있는지 판단한다.
     */
    public void judgment() {
        judgmentTotalMatch();
        judgmentStrikeMatch();
    }

    public BaseballResult getResult() {
        return this.result;
    }

    /**
     * 컴퓨터의 숫자와 사용자가 입력한 숫자를 Set 으로 결합한 후 두 숫자의 총 개수인 6으로 뺄셈한다.
     * 그러면 두 숫자 간 겹치는 개수가 나오며 해당 값을 total 값으로 사용한다.
     */
    private void judgmentTotalMatch() {
        HashSet<Integer> combineNumbers = new HashSet<>(computerNumbers);
        combineNumbers.addAll(inputNumbers);
        int total = SUM_NUMBERS_LENGTH - combineNumbers.size();
        result.changeTotal(total);
    }

    /**
     * 스트라이크가 몇 개 있는지 판단한다.
     */
    private void judgmentStrikeMatch() {
        for (int i = 0; i < computerNumbers.size(); i++)
            matchStrike(computerNumbers, inputNumbers, i);
    }

    /**
     * 컴퓨터의 숫자와 사용자가 입력한 숫자의 자리가 같으면 스트라이크를 증가시킨다.
     *
     * @param computerNumbers 컴퓨터의 숫자
     * @param inputNumbers 사용자가 입력한 숫자
     * @param i 숫자의 순번
     */
    private void matchStrike(List<Integer> computerNumbers, List<Integer> inputNumbers, int i) {
        if (computerNumbers.get(i).equals(inputNumbers.get(i)))
            result.increaseStrike();
    }

}
