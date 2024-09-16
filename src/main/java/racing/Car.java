package racing;

import racingcar.util.NumberCreator;
import racingcar.wrapper.Name;

import java.util.Objects;

public class Car {
    private final Name name;
    private int position = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void move(NumberCreator numberCreator) {
        int forwardNumber = numberCreator.create();
        if (forwardNumber > 9 || forwardNumber < 0) {
            throw new IllegalArgumentException("잘못된 전진숫자입니다. 전진 숫자 0 ~ 9.");
        }
        if (forwardNumber >= 4) {
            position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
