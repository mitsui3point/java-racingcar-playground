package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.RandomNumberGenerator;
import racingcar.wrapper.Name;
import racingcar.wrapper.Position;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingGameTest {

    private String namesInput = "pobi, crong, honux";

    @Test
    void 입력받은_자동차_이름을_split_하여_자동차들을_생성한다() {
        String[] names = Arrays.stream(namesInput.split(","))
                .map(String::trim)
                .toArray(String[]::new);

        RacingGame actual = new RacingGame(namesInput, 1);
        RacingGame expected = new RacingGame(Arrays.asList(
                new Car(new Name(names[0])),
                new Car(new Name(names[1])),
                new Car(new Name(names[2]))
        ), 1);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,5,0",
            "4,5,5",
    })
    void 입력받은_횟수만큼_자동차가_전진한다(int randomNumber, int finishRound, int expectedPosition) {
        String[] names = Arrays.stream(namesInput.split(","))
                .map(String::trim)
                .toArray(String[]::new);

        Car car1 = new Car(new Name(names[0]));
        Car car2 = new Car(new Name(names[1]));
        Car car3 = new Car(new Name(names[2]));

        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2, car3), finishRound);
        racingGame.racing(() -> randomNumber);

        Car expectedCar1 = new Car(new Name(names[0]), new Position(expectedPosition));
        Car expectedCar2 = new Car(new Name(names[1]), new Position(expectedPosition));
        Car expectedCar3 = new Car(new Name(names[2]), new Position(expectedPosition));

        assertThat(car1).isEqualTo(expectedCar1);
        assertThat(car2).isEqualTo(expectedCar2);
        assertThat(car3).isEqualTo(expectedCar3);
    }

    @Test
    void 게임_참여_자동차가_없을_경우_오류가_발생한다() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RacingGame(Arrays.asList(new Car(new Name(""))), 5);
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RacingGame("", 5);
        });
    }

    @Test
    void 게임_최종_라운드가_1보다_작을_경우_오류가_발생한다() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new RacingGame("pobi", 0);
        });
    }
}
