package racingcar.wrapper;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String carsInput) {
        this.cars = convertInputToCars(carsInput);
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> convertInputToCars(String carsInput) {
        return Arrays.stream(carsInput.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void eachCar(Consumer<Car> eachConsumer) {
        cars.forEach(eachConsumer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public Cars maxPosition() {
        return null;
    }

    public Cars getMostMoveCars() {
        Position winnerPosition = getWinnerPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addWinners(winnerPosition, winners, car);
        }
        return Cars.of(winners);
    }

    private void addWinners(Position winnerPosition, List<Car> winners, Car car) {
        if (car.equalPosition(winnerPosition)) {
            winners.add(car);
        }
    }

    private Position getWinnerPosition() {
        Position winnerPosition = new Position(0);
        for (int index = 0; index < cars.size() - 1; index++) {
            winnerPosition = cars.get(index).greaterPosition(cars.get(index + 1));
        }
        return winnerPosition;
    }
}
