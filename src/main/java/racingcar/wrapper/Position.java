package racingcar.wrapper;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        if (isGreaterThanZero(position)) {
            throw new IllegalArgumentException("위치값은 0 보다 작을 수 없습니다.");
        }
        this.position = position;
    }

    private boolean isGreaterThanZero(int position) {
        return position < 0;
    }

    public void forward() {
        position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
