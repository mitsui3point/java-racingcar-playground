package racingcar;

import racingcar.util.NumberGenerator;
import racingcar.wrapper.Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int finishRound;

    public RacingGame(final String nameInput, final int finishRound) {
        List<String> names = Arrays.stream(nameInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        names.forEach(name -> this.cars.add(new Car(new Name(name))));
        this.finishRound = finishRound;
    }

    public RacingGame(final List<Car> cars, final int finishRound) {
        this.cars.addAll(cars);
        this.finishRound = finishRound;
    }

    public void racing(NumberGenerator numberGenerator) {
        for (int round = 0; round < this.finishRound; round++) {
            moveCars(numberGenerator);
        }
    }

    private void moveCars(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return finishRound == that.finishRound && Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, finishRound);
    }
}
