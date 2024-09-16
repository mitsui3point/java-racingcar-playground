package racingcar.wrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @Test
    void 이름을_생성한다() {
        assertThatNoException().isThrownBy(() -> {
            new Name("crong");
        });
    }

    @Test
    void 이름_길이_1글자_성공() {
        assertThatNoException().isThrownBy(() -> {
            new Name("1");
        });
    }

    @Test
    void 이름_길이_5글자_성공() {
        assertThatNoException().isThrownBy(() -> {
            new Name("crong");
        });
    }

    @Test
    void 이름_길이_0글자_실패() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Name("");
        });
    }

    @Test
    void 이름_길이_6글자_실패() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Name("crong1");
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


