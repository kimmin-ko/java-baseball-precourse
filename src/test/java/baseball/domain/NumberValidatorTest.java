package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("숫자 검증기 테스트")
class NumberValidatorTest {

    @DisplayName("사용자 입력 값 검증 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1", "12", "1234", "char", "112"})
    void test(String inputNumber) {
        // when then
        assertThatThrownBy(() -> NumberValidator.validate(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}