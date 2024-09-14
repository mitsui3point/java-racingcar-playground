package racingcar.entity;

import racingcar.util.NumberGenerator;
import racingcar.wrapper.Cars;
import racingcar.wrapper.FinishRound;
import racingcar.wrapper.Name;

import java.util.Arrays;
import java.util.Objects;

public class RacingGame {
    private final Cars cars;
    private final FinishRound finishRound;

    public RacingGame(final String nameInput, final int finishRound) {
        this.cars = new Cars(getCarsFromNames(nameInput));
        this.finishRound = new FinishRound(finishRound);
    }

    public RacingGame(final Cars cars, final FinishRound finishRound) {
        this.cars = cars;
        this.finishRound = finishRound;
    }

    public void racing(NumberGenerator numberGenerator) {
        this.finishRound
                .loopUntilEnd(() -> cars.moveCars(numberGenerator));
    }

    private static Car[] getCarsFromNames(String names) {
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .map(name -> new Car(new Name(name)))
                .toArray(Car[]::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(cars, that.cars) && Objects.equals(finishRound, that.finishRound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, finishRound);
    }
}
