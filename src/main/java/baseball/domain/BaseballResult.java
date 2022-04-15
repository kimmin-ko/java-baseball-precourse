package baseball.domain;

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
     * @return true: 정답, false: 오답
     */
    public boolean isNotAnswer() {
        return this.strike != 3;
    }

    /**
     * 총 일치하는 숫자의 개수 변경
     */
    void changeTotal(int total) {
        this.total = total;
    }

    /**
     * 스트라이크 개수 증가
     */
    void increaseStrike() {
        this.strike++;
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
     * @return 볼 개수
     */
    private int getBall() {
        return this.total - this.strike;
    }

    /**
     * 일치한 숫자의 개수가 0개이면 포볼이다.
     * @return true: 포볼, false: 포볼 아님
     */
    private boolean isFourBall() {
        return this.total <= 0;
    }

    /**
     * 게임 결과를 문자열로 반환
     * @return 게임 결과
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String nothingStr = "낫싱";
        String strikeStr = "스트라이크";
        String ballStr = "볼";

        if (isFourBall())
            result.append(nothingStr);
        else if (hasBoth())
            result.append(getBall()).append(ballStr).append(" ").append(getStrike()).append(strikeStr);
        else if (hasStrike())
            result.append(getStrike()).append(strikeStr);
        else if (hasBall())
            result.append(getBall()).append(ballStr);
        else
            throw new IllegalStateException("숫자 판단 로직이 잘못되었습니다.");

        return result.toString();
    }
}