package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 이동() {
        Car car = new Car("test");
        car.move(4);
        Car expected = new Car("test", 1);
        assertThat(car).isEqualTo(expected);
    }

    @Test
    void 정지() {
        Car car = new Car("test");
        car.move(0);
        Car expected = new Car("test", 0);
        assertThat(car).isEqualTo(expected);
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
