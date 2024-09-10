package racingcar;

public class Car {
    public Car(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름에 null 을 입력할 수 없습니다.");
        }
        int length = name.length();
        if (length > 5 || length < 1) {
            throw new IllegalArgumentException("이름은 1~5글자 사이어야 합니다.");
        }
    }
}
