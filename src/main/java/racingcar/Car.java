package racingcar;

import java.util.Objects;

public class Car {

    public static final int FORWARD_NUMBER = 4;
    public static final int INITIAL_POSITION = 0;
    private final String name;
    private int position;

    public Car(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름에 null 을 입력할 수 없습니다.");
        }
        int length = name.length();
        if (length > 5 || length < 1) {
            throw new IllegalArgumentException("이름은 1~5글자 사이어야 합니다.");
        }
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_NUMBER) {
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
