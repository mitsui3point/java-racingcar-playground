package racingcar;

import racingcar.util.ValidatorUtil;

public class Round {
    private final Movement movement;

    public Round(ForwardNumber forwardNumber) {
        if (forwardNumber.getNumber() >= 4) {
            this.movement = Movement.FORWARD;
            return;
        }
        this.movement = Movement.STOP;
    }

    public Movement getMovement() {
        return movement;
    }
}
