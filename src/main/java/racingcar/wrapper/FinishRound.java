package racingcar.wrapper;

import racingcar.util.Callback;

import java.util.Objects;

public class FinishRound {
    private final int finishRound;

    public FinishRound(int finishRound) {
        if (isInvalidFinishRound(finishRound)) {
            throw new IllegalArgumentException("최종 라운드는 1 보다 작을 수 없습니다.");
        }
        this.finishRound = finishRound;
    }

    private boolean isInvalidFinishRound(int finishRound) {
        return finishRound < 1;
    }

    public void loopUntilEnd(Callback callback) {
        for (int round = 0; round < finishRound; round++) {
            callback.apply();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinishRound that = (FinishRound) o;
        return finishRound == that.finishRound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(finishRound);
    }
}
