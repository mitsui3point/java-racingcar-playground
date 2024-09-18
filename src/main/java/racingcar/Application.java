package racingcar;

import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));

        RacingGame racingGame = new RacingGame(inputView.inputName(), inputView.inputRound());

        ResultView resultView = new ResultView(racingGame);

        resultView.executeResult();
        resultView.winnerResult();
    }
}
