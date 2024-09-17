package racingcar.wrapper;

import racingcar.util.CurrentRoundPrinter;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0보다 작을 수 없습니다.");
        }
        this.position = position;
    }


    public void forward() {
        position++;
    }

    public String print() {
        return CurrentRoundPrinter.printPosition(position);
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

    public int compare(Position target) {
        return this.position - target.position;
    }
}
