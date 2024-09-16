package racingcar;

import racingcar.util.NumberCreator;
import racingcar.wrapper.Cars;
import racingcar.wrapper.Round;

public class RacingGame {
    private final Cars cars;
    private final Round round;

    public RacingGame(String names, int round) {
        this.cars = new Cars(names);
        this.round = new Round(round);
    }

    public void play(NumberCreator numberCreator) {
        cars.moveAll(numberCreator);
    }
}
