package racingcar;

public enum Movement {
    STOP(0), FORWARD(1)
    ;
    private final Integer value;

    Movement(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
