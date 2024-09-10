package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"crong", "c"})
    void 자동차_이름은_1_5_글자_사이이다(String name) {
        assertThatNoException()
                .isThrownBy(() -> new Car(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"crongs"})
    void 자동차_이름은_빈값_혹은_5_글자를_초과할_수_없다(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(name));
    }
}
