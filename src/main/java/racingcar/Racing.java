package racingcar;

import racingcar.util.ValidatorUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> cars;
    private final Integer endRoundIndex;

    public Racing(Integer endRoundIndex, List<String> names) {
        this.endRoundIndex = endRoundIndex;
        this.cars = racing(endRoundIndex, names);
    }

    private List<Car> racing(Integer endRoundIndex, List<String> names) {
        return names.stream()
                .map(name -> getCar(endRoundIndex, name))
                .collect(Collectors.toList());
    }

    private Car getCar(Integer endRoundIndex, String name) {
        ArrayList<Round> rounds = new ArrayList<>();
        for (int roundIndex = 0; roundIndex < endRoundIndex; roundIndex++) {
            rounds.add(new Round(new ForwardNumber(generateForwardNumber())));
        }
        return new Car(name, rounds);
    }

    private Integer generateForwardNumber() {
        int randomDigit = Double.valueOf(Math.random() * 10).intValue();
        while (!ValidatorUtil.forwardNumber(randomDigit)) {
            randomDigit = Double.valueOf(Math.random() * 10).intValue();
        }
        return randomDigit;
    }

    public List<Car> winners() {
        Integer max = cars.stream()
                .map(car -> car.getTotal(endRoundIndex))
                .max(Comparator.comparingInt(t -> t))
                .orElseGet(() -> 0);
        return cars.stream()
                .filter(car -> max.equals(car.getTotal(endRoundIndex)))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
