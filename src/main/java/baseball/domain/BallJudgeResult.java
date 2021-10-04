package baseball.domain;

import static baseball.domain.BallNumbers.*;

import java.util.Objects;

public class BallJudgeResult {
    private static final String STRIKE_OUT_OF_RANGE_EXCEPTION_STATEMENT = "스트라이크의 개수가 범위를 벋어났습니다.";
    private static final String BALL_OUT_OF_RANGE_EXCEPTION_STATEMENT = "볼의 개수가 범위를 벋어났습니다.";

    private final int strikeCount;
    private final int ballCount;

    private BallJudgeResult(int strikeCount, int ballCount) {
        validate(strikeCount, ballCount);
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static BallJudgeResult from(int strikeCount, int ballCount) {
        return new BallJudgeResult(strikeCount, ballCount);
    }

    private void validate(int strikeCount, int ballCount) {
        if (strikeCount < 0 || strikeCount > BALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException(STRIKE_OUT_OF_RANGE_EXCEPTION_STATEMENT);
        }

        if (ballCount < 0 || ballCount > BALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException(BALL_OUT_OF_RANGE_EXCEPTION_STATEMENT);
        }
    }

    public BallJudgeResult increaseStrike() {
        return from(strikeCount + 1, ballCount);
    }

    public BallJudgeResult increaseBall() {
        return from(strikeCount, ballCount + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BallJudgeResult that = (BallJudgeResult)o;
        return strikeCount == that.strikeCount && ballCount == that.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }

    public int strikeCount() {
        return strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }
}
