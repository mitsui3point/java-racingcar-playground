package racingcar;

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

    public void move() {
        if (randomNumber() >= FORWARD_NUMBER) {
            position++;
        }
    }

    protected int randomNumber() {
        return Double.valueOf(Math.random() * 10)
                .intValue();
    }

    public int getPosition() {
        return position;
    }
}
