package racingcar.util;

public class CurrentRoundPrinter {

    public static String printPosition(int printNumber) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < printNumber; index++) {
            result.append("-");
        }
        return result.toString();
    }

}