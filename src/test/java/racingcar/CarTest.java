package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @Test
    void 이름_길이_1글자_성공() {
        assertThatNoException().isThrownBy(() -> {
            new Car("1");
        });
    }

    @Test
    void 이름_길이_5글자_성공() {
        assertThatNoException().isThrownBy(() -> {
            new Car("crong");
        });
    }

    @Test
    void 이름_길이_0글자_실패() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car("");
        });
    }

    @Test
    void 이름_길이_6글자_실패() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car("crong1");
        });
    }

}
