package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.Car;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class CarTest {
    @Test
    void 자동차를_만든다() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Car car = new Car("name");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","crong"})
    void 자동차_이름_길이_성공(String name) {
        assertThatNoException().isThrownBy(() -> {
            new Car(name);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"crong1"})
    void 자동차_이름_길이_실패(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car(name);
        });
    }
}
