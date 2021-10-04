package baseball;

import baseball.domain.BallJudge;
import baseball.domain.BallJudgeResult;
import baseball.domain.BallNumbers;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseBallController {
    public static void innerLoop(BallJudge ballJudge, BallNumbers computerBallNumbers) {
        while (!ballJudge.isGameEnd()) {
            tryAndCatch(ballJudge, computerBallNumbers);
        }
    }

    private static void tryAndCatch(BallJudge ballJudge, BallNumbers computerBallNumbers) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        try {
            BallJudgeResult ballJudgeResult = ballJudge.judge(computerBallNumbers,
                BallNumbers.from(inputView.inputBallNumbers()));
            resultView.outputResult(ballJudgeResult.strikeCount(), ballJudgeResult.ballCount());
        } catch (IllegalArgumentException e) {
            resultView.outputErrorMessage(e.getMessage());
        }
    }
}
