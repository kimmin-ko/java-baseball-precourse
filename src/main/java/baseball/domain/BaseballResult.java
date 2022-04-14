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
     * 총 일치하는 숫자의 개수 변경
     */
    public void changeTotal(int total) {
        this.total = total;
    }

    /**
     * 스트라이크 개수 증가
     */
    public void increaseStrike() {
        this.strike++;
    }

    /**
     * @return 스트라이크 개수
     */
    public int getStrike() {
        return strike;
    }

    /**
     * 총 일치하는 숫자의 개수에서 스트라이크의 개수를 빼면 볼의 개수를 얻을 수 있다.
     * @return 볼 개수
     */
    public int getBall() {
        return this.total - this.strike;
    }

    /**
     * 일치한 숫자의 개수가 0개이면 포볼이다.
     * @return 포볼 여부
     */
    public boolean isFourBall() {
        return this.total <= 0;
    }

    @Override
    public String toString() {
        return null;
    }
}