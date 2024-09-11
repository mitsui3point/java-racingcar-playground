package racingcar.wrapper;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if (isNull(name)) {
            throw new IllegalArgumentException("이름에 null 을 입력할 수 없습니다.");
        }
        int length = name.length();
        if (isNameLength(length)) {
            throw new IllegalArgumentException("이름은 1~5글자 사이어야 합니다.");
        }
        this.name = name;
    }

    private boolean isNameLength(int length) {
        return length > 5 || length < 1;
    }

    private boolean isNull(String name) {
        return name == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
