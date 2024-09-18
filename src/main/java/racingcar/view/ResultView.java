package racingcar.view;

import racingcar.RacingGame;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private final RacingGame racingGame;

    public ResultView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void winnerResult() {

        List<String> results = new ArrayList<>();
        racingGame.winners().eachCar(car -> results.add(car.printName()));
        String result = String.join(", ", results);

        System.out.println(result + "가 최종 우승했습니다.");
    }

    public void executeResult() {
        System.out.println();
        System.out.println("실행 결과");
        racingGame.play(car -> {
            car.move(RandomNumberGenerator::generate);
            System.out.println(car.print());
        });
    }
}
