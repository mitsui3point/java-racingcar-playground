package racingcar;

import racingcar.util.ValidatorUtil;

public class ForwardNumber {
    private final Integer number;

    public ForwardNumber(Integer forwardNumber) {
        if (ValidatorUtil.forwardNumber(forwardNumber)) {
            this.number = forwardNumber;
            return;
        }
        throw new IllegalArgumentException("0~9 사이 1자리 숫자만 입력가능합니다.");
    }

    public Integer getNumber() {
        return number;
    }
}
