package racingcar.view;

import racingcar.Car;
import racingcar.Racing;

public class ResultView {

    public static final String FORWARD_PRINT = "-";
    public void playRacing(Integer endRoundIndex, Racing racing) {
        System.out.println("실행 결과");
        printRoundResult(endRoundIndex, racing);
    }

    private static void printRoundResult(Integer endRoundIndex, Racing racing) {
        for (int round = 1; round <= endRoundIndex; round++) {
            printRoundCarResult(racing, round);
            System.out.println();
        }
    }

    private static void printRoundCarResult(Racing racing, int round) {
        for (Car car : racing.getCars()) {
            System.out.println(car.getName() + ": " + printForward(car.getTotal(round)));
        }
    }


    private static String printForward(Integer total) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < total; index++) {
            stringBuilder.append(FORWARD_PRINT);
        }
        return stringBuilder.toString();
    }

    public void result(Racing racing) {
        String[] results = racing.winners().stream().map(Car::getName).toArray(String[]::new);
        String result = String.join(", ", results);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
