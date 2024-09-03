package racingcar;

import java.util.List;

public class Car {
    private final List<Round> rounds;

    public Car(List<Round> rounds) {
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

}
