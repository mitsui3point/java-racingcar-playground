package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

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
        Car actualCar = new Car(rounds);
        List<Round> actual = actualCar.getRounds();
        Integer total = actualCar.getTotal(roundIndex);
        
        assertThat(actual).isEqualTo(rounds);
        assertThat(total).isEqualTo(expectedTotal);
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
