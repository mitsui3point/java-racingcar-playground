package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.wrapper.Cars;
import racingcar.wrapper.Round;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 레이싱게임_생성() {
        RacingGame racingGame = new RacingGame("pobi,crong,honux", 3);

        Cars cars = new Cars("pobi,crong,honux");
        Round round = new Round(3);

        assertThat(racingGame).extracting("cars").isEqualTo(cars);
        assertThat(racingGame).extracting("round").isEqualTo(round);
    }

    @Test
    void 횟수만큼_자동차들이_전진한다() {
        RacingGame racingGame = new RacingGame("pobi,crong,honux", 3);

        List<Car> expectedCar = Arrays.asList(
                new Car("pobi", 3),
                new Car("crong", 3),
                new Car("honux", 3)
        );
        racingGame.play(car -> car.move(() -> 4));
        Round round = new Round(3);

        assertThat(racingGame)
                .extracting("cars")
                .extracting("cars")
                .isEqualTo(expectedCar);
        assertThat(racingGame).extracting("round").isEqualTo(round);
    }

    @Test
    void 자동차_경주_게임_우승자동차들을_추려낸다() {
        RacingGame racingGame = new RacingGame("pobi,crong,honux", 3);

        List<Car> expectedCar = Arrays.asList(
                new Car("pobi", 3),
                new Car("crong", 3)
        );
        racingGame.play(car -> {
            if (car.print().contains("pobi")) {
                car.move(() -> 4);
                return;
            }
            if (car.print().contains("crong")) {
                car.move(() -> 4);
                return;
            }
            car.move(() -> 3);
        });
        Cars actualWinners = racingGame.winners();
        Cars expectedWinners = Cars.of(expectedCar);

        assertThat(actualWinners).isEqualTo(expectedWinners);
    }
}
