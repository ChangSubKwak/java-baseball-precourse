package baseball.domain;

import static baseball.domain.BallNumber.*;
import static baseball.domain.BallNumbers.*;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class BallCreator {
    public static BallNumbers create() {
        List<Integer> ballNumbersList = new ArrayList<>();

        while (ballNumbersList.size() < BALL_NUMBERS_SIZE) {
            addRandomBallNumber(ballNumbersList);
        }
        return BallNumbers.from(ballNumbersList);
    }

    private static void addRandomBallNumber(List<Integer> ballNumbersList) {
        int value = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        if (ballNumbersList.contains(value)) {
            return;
        }
        ballNumbersList.add(value);
    }
}
