package racingcar.model;

import java.util.Arrays;
import java.util.List;
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
}
