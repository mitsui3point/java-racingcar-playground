package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
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
