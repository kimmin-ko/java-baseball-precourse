package baseball.domain;

import static baseball.domain.BaseballNumberRule.ANSWER_COUNT;

/**
 * 컴퓨터 숫자와 사용자가 입력한 숫자 비교에 대한 결과 값
 *
 * @author : kimmin
 * @since : 2022-04-14 오후 21:41
 */
public class BaseballResult {

    private int total;
    private int strike;

    /**
     * 사용자가 입력한 숫자가 정답인지 확인한다.
     *
     * @return true: 정답, false: 오답
     */
    public boolean isNotAnswer() {
        return this.strike != ANSWER_COUNT.value();
    }

    /**
     * 총 일치하는 숫자의 개수 변경
     * 변경하려는 값이 정답 개수보다 많으면 예외를 발생시킨다.
     */
    void changeTotal(int total) {
        if (isTotalGreaterThanAnswerCount(total)) {
            throw new IllegalArgumentException("총 일치 개수가 정답 개수보다 많을 수 없습니다.");
        }

        this.total = total;
    }

    /**
     * 스트라이크 개수를 증가시킨다.
     * 이미 3이상이면 예외를 발생시킨다.
     */
    void increaseStrike() {
        if (isStrikeGoeAnswerCount()) {
            throw new IllegalStateException("스트라이크를 더이상 증가시킬 수 없습니다.");
        }

        this.strike++;
    }

    /**
     * 변경하려는 총 일치 개수가 정답 개수 초과인지 확인한다.
     *
     * @return true: 초과, false: 이하
     */
    private boolean isTotalGreaterThanAnswerCount(int total) {
        return total > ANSWER_COUNT.value();
    }

    /**
     * 스트라이크 개수가 정답 개수 이상인지 확인한다.
     *
     * @return true: 이상, false: 미만
     */
    private boolean isStrikeGoeAnswerCount() {
        return this.strike >= ANSWER_COUNT.value();
    }

    /**
     * @return true: 스트라이크 있음, false: 스트라이크 없음
     */
    private boolean hasStrike() {
        return strike > 0;
    }

    /**
     * @return true: 볼 있음, false: 볼 없음
     */
    private boolean hasBall() {
        return getBall() > 0;
    }

    /**
     * @return true: 스트라이크와 볼이 모두 있음, false: 하나라도 없음
     */
    private boolean hasBoth() {
        return hasStrike() && hasBall();
    }

    /**
     * @return 스트라이크 개수
     */
    private int getStrike() {
        return this.strike;
    }

    /**
     * 총 일치하는 숫자의 개수에서 스트라이크의 개수를 빼면 볼의 개수를 얻을 수 있다.
     *
     * @return 볼 개수
     */
    private int getBall() {
        return this.total - this.strike;
    }

    /**
     * 일치한 숫자의 개수가 0개이면 포볼이다.
     *
     * @return true: 포볼, false: 포볼 아님
     */
    private boolean isFourBall() {
        return this.total <= 0;
    }

    /**
     * 게임 결과를 문자열로 반환
     *
     * @return 게임 결과
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (isFourBall()) {
            result.append("낫싱");
        } else if (hasBoth()) {
            result.append(getBall()).append("볼").append(" ").append(getStrike()).append("스트라이크");
        } else if (hasStrike()) {
            result.append(getStrike()).append("스트라이크");
        } else if (hasBall()) {
            result.append(getBall()).append("볼");
        } else {
            throw new IllegalStateException("숫자 판단 로직이 잘못되었습니다.");
        }

        return result.toString();
    }
}