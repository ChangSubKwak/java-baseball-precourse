package baseball.domain;

import static baseball.domain.BallNumbers.*;

import java.util.List;

public class BallJudge {
    private static final int NOT_FOUND_INDEX = -1;
    private static final int INITIAL_STRIKE_COUNT = 0;
    private static final int INITIAL_BALL_COUNT = 0;

    private BallJudgeResult ballJudgeResult;

    public BallJudge() {
        ballJudgeResult = BallJudgeResult.from(INITIAL_STRIKE_COUNT, INITIAL_BALL_COUNT);
    }

    public BallJudgeResult judge(BallNumbers computerBallNumbers, BallNumbers humanBallNumbers) {
        ballJudgeResult = BallJudgeResult.from(INITIAL_STRIKE_COUNT, INITIAL_BALL_COUNT);
        List<BallNumber> computerBallList = computerBallNumbers.toList();
        List<BallNumber> humanBallList = humanBallNumbers.toList();
        for (int i = 0; i < BALL_NUMBERS_SIZE; i++) {
            int indexOfHumanBallInComputerBall = computerBallList.indexOf(humanBallList.get(i));
            calculateStrikeAndBall(i, indexOfHumanBallInComputerBall);
        }
        return ballJudgeResult;
    }

    private void calculateStrikeAndBall(int computerBallIndex, int indexOfHumanBallInComputerBall) {
        if (indexOfHumanBallInComputerBall == NOT_FOUND_INDEX) {
            return;
        }

        if (computerBallIndex == indexOfHumanBallInComputerBall) {
            increaseStrike();
            return;
        }
        increaseBall();
    }

    private void increaseStrike() {
        ballJudgeResult = ballJudgeResult.increaseStrike();
    }

    private void increaseBall() {
        ballJudgeResult = ballJudgeResult.increaseBall();
    }

    public boolean isGameEnd() {
        return ballJudgeResult.strikeCount() == BALL_NUMBERS_SIZE;
    }
}
