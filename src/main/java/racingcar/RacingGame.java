package racingcar;

import racingcar.model.Car;
import racingcar.wrapper.Cars;
import racingcar.wrapper.Round;

import java.util.function.Consumer;

public class RacingGame {
    private final Cars cars;
    private final Round round;

    public RacingGame(String names, int round) {
        this.cars = new Cars(names);
        this.round = new Round(round);
    }

    public void play(Consumer<Car> eachConsumer) {
        round.eachRoundPlay(() -> {
            cars.eachCar(eachConsumer);
            System.out.println();
        });
    }

    public Cars winners() {
        return cars.getMostMoveCars();
    }

}
