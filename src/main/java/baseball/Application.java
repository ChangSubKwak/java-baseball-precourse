package baseball;

import baseball.domain.BallCreator;
import baseball.domain.BallJudge;
import baseball.domain.BallNumbers;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        do {
            BallJudge ballJudge = new BallJudge();
            BallNumbers computerBallNumbers = BallCreator.create();
            BaseBallController.innerLoop(ballJudge, computerBallNumbers);
        } while (inputView.inputRetry());
    }
}
