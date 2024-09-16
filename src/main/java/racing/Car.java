package racing;

import racingcar.wrapper.Name;

public class Car {
    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
    }
}
