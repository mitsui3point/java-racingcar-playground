package racingcar.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

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
}
