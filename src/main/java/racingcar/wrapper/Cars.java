package racingcar.wrapper;

import racingcar.model.Car;

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
}
