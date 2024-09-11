package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.wrapper.Name;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    void 입력받은_자동차_이름을_split_하여_자동차들을_생성한다() {
        String namesInput = "pobi, crong, honux";
        String[] names = Arrays.stream(namesInput.split(","))
                .map(String::trim)
                .toArray(String[]::new);

        RacingGame actual = new RacingGame(namesInput);
        RacingGame expected = new RacingGame(Arrays.asList(
                new Car(new Name(names[0])),
                new Car(new Name(names[1])),
                new Car(new Name(names[2]))
        ));
        assertThat(actual).isEqualTo(expected);
    }
}
