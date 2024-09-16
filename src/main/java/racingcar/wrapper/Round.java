package racingcar.wrapper;

public class Round {
    public Round(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("횟수는 최소 1 이상이어야 합니다.");
        }
    }
}
