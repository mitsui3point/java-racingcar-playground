package racingcar.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {
    @Test
    void 위치_생성() {
        assertThatNoException().isThrownBy(() -> {
            new Position(0);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1})
    void 위치_생성_실패(int position) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Position(position);
        });
    }

    @Test
    void 위치_동등_비교() {
        Position actual = new Position(1);
        Position expected = new Position(1);
        assertThat(actual).isEqualTo(expected);

        Position actualNe = new Position(2);
        Position expectedNe = new Position(1);
        assertThat(actualNe).isNotEqualTo(expectedNe);
    }

    @Test
    void 위치_전진() {
        Position actual = new Position(0);
        Position expected = new Position(1);
        actual.forward();

        assertThat(actual).isEqualTo(expected);
    }
}