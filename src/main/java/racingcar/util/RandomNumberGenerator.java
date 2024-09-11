package racingcar.util;

public class RandomNumberGenerator implements NumberGenerator{
    public int generate() {
        return Double.valueOf(Math.random() * 10)
                .intValue();
    }
}
