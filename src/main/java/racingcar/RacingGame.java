package racingcar;

import racingcar.wrapper.Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(final String nameInput) {
        List<String> names = Arrays.stream(nameInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        names.forEach(name -> this.cars.add(new Car(new Name(name))));
    }

    public RacingGame(final List<Car> cars) {
        this.cars.addAll(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
