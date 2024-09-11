package racingcar;

import racingcar.wrapper.Name;
import racingcar.wrapper.Position;

import java.util.Objects;

public class Car {

    public static final int FORWARD_NUMBER = 4;
    private final Name name;
    private final Position position;

    public Car(final Name name) {
        this.name = name;
        this.position = new Position(0);
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_NUMBER) {
            position.forward();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
