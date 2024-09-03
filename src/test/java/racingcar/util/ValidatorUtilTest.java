package racingcar.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorUtilTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "asdfv",
            "asdf",
            "asd",
            "as",
            "a",
            "김수한무거"
    })
    void 자동차_이름은_5자를_초과할_수_없다(String name) {
        boolean actual = ValidatorUtil.carNameLength(name);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_이름에_빈값이_입력될_수_없다(String name) {
        boolean actual = ValidatorUtil.carNameLength(name);
        assertThat(actual).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {
            0,1,2,3,4,5,6,7,8,9
    })
    void 전진숫자가_0_9_사이의_값이어야_한다(Integer forwardNumber) {
        boolean actual = ValidatorUtil.forwardNumber(forwardNumber);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {
            -1,11,Integer.MAX_VALUE,Integer.MIN_VALUE
    })
    void 전진숫자가_0_보다_작거나_9보다_클수_없다(Integer forwardNumber) {
        boolean actual = ValidatorUtil.forwardNumber(forwardNumber);
        assertThat(actual).isFalse();
    } 
}
