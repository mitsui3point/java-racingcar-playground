package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public Integer getEndRoundIndex() {
        System.out.println("시도할 회수는 몇회인가요?");
        Integer endRoundIndex = scanner.nextInt();
        System.out.println();
        return endRoundIndex;
    }
}
