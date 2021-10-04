package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class BallNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    private static final String BALL_NUMBER_OUT_OF_RANGE_EXCEPTION_STATEMENT = "볼 넘버가 범위를 벗어났습니다.";
    private static final Map<Integer, BallNumber> ballNumberMap;

    static {
        ballNumberMap = new HashMap<>();
        for (int i = MIN_VALUE; i < MAX_VALUE; i++) {
            ballNumberMap.put(i, new BallNumber(i));
        }
    }

    private final int ballNumber;

    private BallNumber(int ballNumber) {
        validate(ballNumber);
        this.ballNumber = ballNumber;
    }

    public static BallNumber from(int ballNumber) {
        validate(ballNumber);
        return ballNumberMap.get(ballNumber);
    }

    private static void validate(int ballNumber) {
        if (ballNumber < BallNumber.MIN_VALUE || ballNumber > BallNumber.MAX_VALUE) {
            throw new IllegalArgumentException(BALL_NUMBER_OUT_OF_RANGE_EXCEPTION_STATEMENT);
        }
    }
}
