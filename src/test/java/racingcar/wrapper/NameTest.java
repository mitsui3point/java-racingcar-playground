package racingcar.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @Test
    void 이름을_생성한다() {
        assertThatNoException().isThrownBy(() -> {
            new Name("crong");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","crong"})
    void 이름_길이_성공(String name) {
        assertThatNoException().isThrownBy(() -> {
            new Name(name);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"crong1"})
    void 이름_길이_실패(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Name(name);
        });
    }

    @Test
    void 이름이_같으면_이름객체도_동일하다() {
        Name actual = new Name("same");
        Name expected = new Name("same");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 이름이_다르면_이름객체도_동일하지_않다() {
        Name actual = new Name("same1");
        Name expected = new Name("same");
        assertThat(actual).isNotEqualTo(expected);
    }
}


