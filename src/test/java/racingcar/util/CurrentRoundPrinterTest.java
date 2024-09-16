package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrentRoundPrinterTest {
    @Test
    void 자동차가_이동한_만큼_대쉬문자를_생성한다() {
        String actual = CurrentRoundPrinter.printPosition(2);
        String expected = "--";

        assertThat(actual).isEqualTo(expected);
    }

}
