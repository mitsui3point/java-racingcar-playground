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

    @Test
    void 위치_출력() {
        Position position = new Position(2);
        String printPosition = position.print();
        String expected = "--";

        assertThat(printPosition).isEqualTo(expected);
    }

    @Test
    void 위치_비교() {
        Position position = new Position(1);
        Position positionLess = new Position(1);
        Position positionGreater = new Position(2);

        int compareMinus = positionLess.compare(positionGreater);
        int comparePlus = positionGreater.compare(positionLess);
        int compareZero = position.compare(position);

        assertThat(compareMinus).isLessThan(0);
        assertThat(comparePlus).isGreaterThan(0);
        assertThat(compareZero).isEqualTo(0);
    }
}