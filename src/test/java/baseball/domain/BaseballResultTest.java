package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballResultTest {

    BaseballResult result;

    @BeforeEach
    void setup() {
        // given
        result = new BaseballResult();

        // when
        boolean isNotAnswer = result.isNotAnswer();

        // then
        assertThat(isNotAnswer).isTrue();
    }

    @ParameterizedTest
    @CsvSource("3, 4")
    @DisplayName("정답 개수를 초과하는 총 일치 개수가 입력되면 예외가 발생한다.")
    void throw_exception_because_total_greater_than_answer_count(int total, int totalGreaterThanAnswerCount) {
        // when
        result.changeTotal(total);

        // then
        assertThat(result.toString()).hasToString("3볼");

        // fail
        assertThatThrownBy(() -> result.changeTotal(totalGreaterThanAnswerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("총 일치 개수가 정답 개수보다 많을 수 없습니다.");
    }

    @Test
    @DisplayName("")
    void test() {
        // given
        int total = 3;

        // when
        result.changeTotal(total);

        // then
        assertThat(result.toString()).hasToString("3볼");
        assertThat(result.isNotAnswer()).isTrue();

        // when
        result.increaseStrike();

        // then
        assertThat(result.toString()).hasToString("2볼 1스트라이크");
        assertThat(result.isNotAnswer()).isTrue();

        // when
        result.increaseStrike();

        // then
        assertThat(result.toString()).hasToString("1볼 2스트라이크");
        assertThat(result.isNotAnswer()).isTrue();

        // when
        result.increaseStrike();

        // then
        assertThat(result.toString()).hasToString("3스트라이크");
        assertThat(result.isNotAnswer()).isFalse();

        // fail
        assertThatThrownBy(() -> result.increaseStrike())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("스트라이크를 더이상 증가시킬 수 없습니다.");
    }

}