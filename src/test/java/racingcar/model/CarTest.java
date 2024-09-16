package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 자동차를_만든다() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Car car = new Car("name", 1);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "crong"})
    void 자동차_이름_길이_성공(String name) {
        assertThatNoException().isThrownBy(() -> {
            new Car(name, 1);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"crong1"})
    void 자동차_이름_길이_실패(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car(name, 1);
        });
    }

    @Test
    void 자동차_위치_입력() {
        assertThatNoException().isThrownBy(() -> {
            new Car("car", 1);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1})
    void 자동차_위치_입력_실패(int position) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car("Car", position);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_전진(int forwardNumber) {
        Car actual = new Car("car");
        Car expectedCar = new Car("car", 1);

        actual.move(() -> forwardNumber);

        assertThat(actual).isEqualTo(expectedCar);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차_정지(int forwardNumber) {
        Car actual = new Car("car");
        Car expected = new Car("car", 0);

        actual.move(() -> forwardNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void 자동차_예외(int forwardNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Car actual = new Car("car");
            actual.move(() -> forwardNumber);
        });
    }
}
