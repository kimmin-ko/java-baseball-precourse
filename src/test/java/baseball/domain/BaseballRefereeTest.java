package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballRefereeTest {

    @ParameterizedTest
    @MethodSource("provideThreeStrike")
    @DisplayName("3 스트라이크 테스트")
    void three_strike(List<Integer> computerNumbers, List<Integer> inputNumbers) {
        // given
        BaseballReferee referee = new BaseballReferee(computerNumbers, inputNumbers);

        // when
        referee.judgment();
        BaseballResult result = referee.getResult();

        // then
        assertThat(result.toString()).hasToString("3스트라이크");
    }

    private static Stream<Arguments> provideThreeStrike() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("provideOneBallOneStrike")
    @DisplayName("1볼 1스트라이크 테스트")
    void one_ball_one_strike(List<Integer> computerNumbers, List<Integer> inputNumbers) {
        // given
        BaseballReferee referee = new BaseballReferee(computerNumbers, inputNumbers);

        // when
        referee.judgment();
        BaseballResult result = referee.getResult();

        // then
        assertThat(result.toString()).hasToString("1볼 1스트라이크");
    }

    private static Stream<Arguments> provideOneBallOneStrike() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 4), Arrays.asList(2, 5, 4)),
                Arguments.of(Arrays.asList(5, 1, 3), Arrays.asList(5, 3, 2)),
                Arguments.of(Arrays.asList(6, 7, 2), Arrays.asList(2, 7, 1)),
                Arguments.of(Arrays.asList(9, 3, 7), Arrays.asList(9, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTwoBallOneStrike")
    @DisplayName("2볼 1스트라이크 테스트")
    void two_ball_one_strike(List<Integer> computerNumbers, List<Integer> inputNumbers) {
        // given
        BaseballReferee referee = new BaseballReferee(computerNumbers, inputNumbers);

        // when
        referee.judgment();
        BaseballResult result = referee.getResult();

        // then
        assertThat(result.toString()).hasToString("2볼 1스트라이크");
    }

    private static Stream<Arguments> provideTwoBallOneStrike() {
        return Stream.of(
                Arguments.of(Arrays.asList(4, 5, 2), Arrays.asList(2, 5, 4)),
                Arguments.of(Arrays.asList(5, 1, 3), Arrays.asList(1, 5, 3)),
                Arguments.of(Arrays.asList(6, 7, 2), Arrays.asList(6, 2, 7)),
                Arguments.of(Arrays.asList(9, 3, 7), Arrays.asList(9, 7, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTwoStrike")
    @DisplayName("2스트라이크 테스트")
    void two_strike(List<Integer> computerNumbers, List<Integer> inputNumbers) {
        // given
        BaseballReferee referee = new BaseballReferee(computerNumbers, inputNumbers);

        // when
        referee.judgment();
        BaseballResult result = referee.getResult();

        // then
        assertThat(result.toString()).hasToString("2스트라이크");
    }

    private static Stream<Arguments> provideTwoStrike() {
        return Stream.of(
                Arguments.of(Arrays.asList(4, 5, 2), Arrays.asList(4, 5, 1)),
                Arguments.of(Arrays.asList(5, 1, 3), Arrays.asList(5, 1, 7)),
                Arguments.of(Arrays.asList(6, 7, 2), Arrays.asList(5, 7, 2)),
                Arguments.of(Arrays.asList(9, 3, 7), Arrays.asList(9, 3, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("provideNothing")
    @DisplayName("낫싱 테스트")
    void nothing(List<Integer> computerNumbers, List<Integer> inputNumbers) {
        // given
        BaseballReferee referee = new BaseballReferee(computerNumbers, inputNumbers);

        // when
        referee.judgment();
        BaseballResult result = referee.getResult();

        // then
        assertThat(result.toString()).hasToString("낫싱");
    }

    private static Stream<Arguments> provideNothing() {
        return Stream.of(
                Arguments.of(Arrays.asList(4, 5, 2), Arrays.asList(1, 7, 6)),
                Arguments.of(Arrays.asList(5, 1, 3), Arrays.asList(7, 8, 2)),
                Arguments.of(Arrays.asList(6, 7, 2), Arrays.asList(4, 9, 1)),
                Arguments.of(Arrays.asList(9, 3, 7), Arrays.asList(2, 4, 1))
        );
    }
}