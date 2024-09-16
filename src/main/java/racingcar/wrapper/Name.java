package racingcar.wrapper;


import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException("이름은 1글자와 5글자 사이어야 합니다.");
        }
        this.name = name;
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
