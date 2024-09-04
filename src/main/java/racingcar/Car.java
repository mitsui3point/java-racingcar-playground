package racingcar;

import racingcar.util.ValidatorUtil;

import java.util.List;

import static racingcar.util.ValidatorUtil.*;

public class Car {
    private final String name;
    private final List<Round> rounds;

    public Car(String name, List<Round> rounds) {
        if (!carNameLength(name)) {
            throw new IllegalArgumentException("이름은 1~5자 사이의 값을 입력해주세요.");
        }
        this.name = name;
        this.rounds = rounds;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public Integer getTotal(int roundIndex) {
        Integer total = 0;
        for (int index = 0; index < roundIndex; index++) {
            total += getForwardNumber(index);
        }
        return total;
    }

    private Integer getForwardNumber(int index) {
        return rounds.get(index)
                .getMovement()
                .getValue();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", rounds=" + rounds +
                '}';
    }
}
