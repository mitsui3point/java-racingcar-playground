package racingcar.util;

public class RandomNumberGenerator {
    public static int generate() {
        return Double.valueOf(Math.random() * 10).intValue();
    }
}
