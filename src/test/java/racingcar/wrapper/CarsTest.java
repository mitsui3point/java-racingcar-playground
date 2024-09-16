package racingcar.wrapper;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void 자동차_이름을_split_하여_자동차들을_생성한다() {
        String carsInput = "pobi, crong, honux";
        Cars cars = new Cars(carsInput);
        List<Car> expected = Arrays.asList(
                new Car("pobi"),
                new Car("crong"),
                new Car("honux"));

        assertThat(cars).extracting("cars").isEqualTo(expected);
    }

}
