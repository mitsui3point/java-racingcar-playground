package racingcar.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RoundTest {
    @Test
    void 횟수_생성() {
        assertThatNoException().isThrownBy(() -> {
            new Round(1);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, Integer.MIN_VALUE})
    void 횟수_생성_실패(int round) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Round(round);
        });
    }

    @Test
    void 동등_비교() {
        assertThat(new Round(1)).isEqualTo(new Round(1));
    }

    @Test
    void 횟수만큼_메서드를_실행한다() {
        Round round = new Round(2);
        Cars cars = new Cars("pobi,crong,honux");
        round.eachRoundPlay(() -> cars.eachCar(car -> car.move(() -> 4)));

        List<Car> expected = Arrays.asList(
                new Car("pobi", 2),
                new Car("crong", 2),
                new Car("honux", 2)
        );
        assertThat(cars).extracting("cars").isEqualTo(expected);
    }
}
