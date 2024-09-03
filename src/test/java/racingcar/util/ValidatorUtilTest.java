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
}
