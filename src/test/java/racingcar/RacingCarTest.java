package racingcar;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void 자동차_경주_게임을_완료한_후_누가_우승했는지를_알려준다() {
        Integer roundNum = 5;
        List<String> names = Arrays.asList("honux", "crong", "pobi");
        Racing racing = new Racing(roundNum, names);

        List<Car> winners = racing.winners();
        List<Car> exceptWinners = racing.getCars()
                .stream()
                .filter(p -> !winners.contains(p))
                .collect(Collectors.toList());

        if (winners.size() == 3) {
            assertThat(winners.get(0).getTotal(roundNum)).isEqualTo(winners.get(1).getTotal(roundNum));
            assertThat(winners.get(1).getTotal(roundNum)).isEqualTo(winners.get(2).getTotal(roundNum));
        }
        if (winners.size() == 2) {
            assertThat(winners.get(0).getTotal(roundNum)).isEqualTo(winners.get(1).getTotal(roundNum));
            assertThat(winners.get(0).getTotal(roundNum)).isGreaterThan(exceptWinners.get(0).getTotal(roundNum));
        }
        if (winners.size() == 1) {
            assertThat(winners.get(0).getTotal(roundNum)).isGreaterThan(exceptWinners.get(0).getTotal(roundNum));
            assertThat(winners.get(0).getTotal(roundNum)).isGreaterThan(exceptWinners.get(1).getTotal(roundNum));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0,1,2,3,4,2,0",
            "0,1,2,5,4,3,0",
            "0,1,6,5,4,4,2",
            "0,7,6,5,4,5,4",
            "8,7,6,5,4,4,4",
            "4,9,5,6,7,5,5",
    })
    void 차_총_5라운드_각각_전진_total_을_구한다(
            Integer first,
            Integer second,
            Integer third,
            Integer fourth,
            Integer fifth,
            Integer roundIndex,
            Integer expectedTotal) {
        List<Round> rounds = Arrays.asList(
                new Round(new ForwardNumber(first)),
                new Round(new ForwardNumber(second)),
                new Round(new ForwardNumber(third)),
                new Round(new ForwardNumber(fourth)),
                new Round(new ForwardNumber(fifth))
        );
        Car actualCar = new Car("name", rounds);
        List<Round> actual = actualCar.getRounds();
        Integer total = actualCar.getTotal(roundIndex);

        assertThat(actual).isEqualTo(rounds);
        assertThat(total).isEqualTo(expectedTotal);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"honuxd", "crongww", "pobiqq"})
    void 자동차_이름은_5자초과_및_빈값은_등록할_수_없다(String name) {
        assertThatThrownBy(() -> {
            new Car(name, Arrays.asList());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"honux", "crong", "pobi"})
    void 자동차_이름을_등록한다(String name) {
        Car car = new Car(name, Arrays.asList());
        assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8})
    void random_값이_4이상일_경우_전진한다(Integer number) {
        Movement actual = new Round(new ForwardNumber(number)).getMovement();
        Movement expected = Movement.FORWARD;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void random_값이_4미만일_경우_전진하지_않는다(Integer number) {
        Movement actual = new Round(new ForwardNumber(number)).getMovement();
        Movement expected = Movement.STOP;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, Integer.MAX_VALUE, -1, 10})
    void random_값이_0미만_9초과일_경우_값을_입력받지_않는다(Integer number) {
        assertThatThrownBy(() -> {
            new Round(new ForwardNumber(number)).getMovement();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
