package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import util.Result;
import util.AddCalculator;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class AddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {""})
    @DisplayName("빈 문자열 0 리턴")
    void nullAndEmptyTextReturnZero(String text) {
        AddCalculator addCalculator = new AddCalculator(text);
        Result result = addCalculator.parse();
        Result expected = new Result(Integer.parseInt("0"));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3", "33"})
    @DisplayName("숫자 문자열 한개 입력시 그대로 리턴")
    void onlyOneNumberTextReturnsSelf(String text) {
        AddCalculator addCalculator = new AddCalculator(text);
        Result result = addCalculator.parse();
        Result expected = new Result(Integer.parseInt(text));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideCommaOrColonDelimiter")
    @DisplayName("숫자 문자열과 콤마 OR 콜론 구분자 입력시 배열리턴")
    void commaOrColonDelimiterWithNumberTextReturnsArray(String text, Integer result) {
        AddCalculator addCalculator = new AddCalculator(text);
        Result actual = addCalculator.parse();
        Result expected = new Result(result);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideCustomDelimiter")
    @DisplayName("숫자 문자열과 커스텀 구분자 입력시 배열리턴")
    void customDelimiterWithNumberTextReturnsArray(String text, Integer result) {
        AddCalculator addCalculator = new AddCalculator(text);
        Result actual = addCalculator.parse();
        Result expected = new Result(result);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideCommaOrColonDelimiter() {
        return Stream.of(
                Arguments.of("0,1", 1),
                Arguments.of("1,2,3", 6),
                Arguments.of("1,2:3", 6),
                Arguments.of("33:55,3214", 33 + 55 + 3214)
        );
    }

    public static Stream<Arguments> provideCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 1+2+3),
                Arguments.of("//;\n1;2;3", 1+2+3),
                Arguments.of("//?\n44?55?1234", 44+55+1234),
                Arguments.of("//!\n44!55!1234", 44+55+1234)
        );
    }

}
