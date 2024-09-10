package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class CarTest {

    @Test
    void 이동() {
        Car car = new Car("test") {
            @Override
            protected int randomNumber() {
                return 4;
            }
        };
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 정지() {
        Car car = new Car("test") {
            @Override
            protected int randomNumber() {
                return 0;
            }
        };
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

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
