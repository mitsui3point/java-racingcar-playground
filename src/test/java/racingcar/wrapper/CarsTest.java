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

    @Test
    void 동등_비교() {
        String carsInput = "pobi, crong, honux";
        Cars cars = new Cars(carsInput);
        String carsInputEq = "pobi, crong, honux";
        Cars carsEq = new Cars(carsInputEq);
        assertThat(cars).isEqualTo(carsEq);

        String carsInputNe = "pob, cron, honux";
        Cars carsNe = new Cars(carsInputNe);
        assertThat(cars).isNotEqualTo(carsNe);
    }

    @Test
    void 모든_차들이_1회_이동한다() {
        Cars cars = new Cars("pobi,crong,honux");
        cars.eachCarMove(() -> 4);

        List<Car> expected = Arrays.asList(
                new Car("pobi", 1),
                new Car("crong", 1),
                new Car("honux", 1)
        );
        assertThat(cars).extracting("cars").isEqualTo(expected);
    }
}
