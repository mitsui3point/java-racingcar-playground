package racingcar.util;

import java.util.Optional;

public class ValidatorUtil {
    public static boolean carNameLength(String carName) {
        return carName != null &&
                !carName.isEmpty() &&
                carName.length() <= 5;
    }

    public static boolean forwardNumber(Integer forwardNumber) {
        return forwardNumber >= 0 &&
                forwardNumber <= 9;
    }
}
