package racingcar.wrapper;

import racingcar.util.RoundPlay;

import java.util.Objects;

public class Round {
    private final int round;

    public Round(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("횟수는 최소 1 이상이어야 합니다.");
        }
        this.round = round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }

    public void playEachRound(RoundPlay roundPlay) {
        for (int current = 0; current < round; current++) {
            roundPlay.apply();
        }
    }
}
