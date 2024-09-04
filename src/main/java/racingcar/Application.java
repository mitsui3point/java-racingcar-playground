package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String input = inputView.getName();
        Integer endRoundIndex = inputView.getEndRoundIndex();

        Racing racing = new Racing(endRoundIndex, Arrays.asList(input.split(",")));

        ResultView resultView = new ResultView();
        resultView.playRacing(endRoundIndex, racing);
        resultView.result(racing);
    }
}
