package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BallNumbers {
    public static final int BALL_NUMBERS_SIZE = 3;
    private static final String BALL_NUMBERS_IS_NULL_EXCEPTION_STATEMENT = "볼 넘버값이 null또는 빈값입니다.";
    private static final String BALL_NUMBERS_SIZE_EXCEPTION_STATEMENT = "볼 넘버값 배열의 크기가 3이 아닙니다.";
    private static final String BALL_NUMBERS_DUPLICATION_EXCEPTION_STATEMENT = "볼 넘버값이 중복됩니다.";

    List<BallNumber> ballNumbers;

    private BallNumbers(List<Integer> ballNumbers) {
        validate(ballNumbers);
        this.ballNumbers = new ArrayList<>();
        for (int i = 0; i < BALL_NUMBERS_SIZE; i++) {
            this.ballNumbers.add(BallNumber.from(ballNumbers.get(i)));
        }
    }

    public static BallNumbers from(List<Integer> ballNumbers) {
        return new BallNumbers(ballNumbers);
    }

    public static BallNumbers from(String ballNumbersString) {
        validateString(ballNumbersString);
        List<Integer> ballNumbers = new ArrayList<>();
        for (int i = 0; i < ballNumbersString.length(); i++) {
            ballNumbers.add(Integer.valueOf(ballNumbersString.charAt(i) + ""));
        }
        return new BallNumbers(ballNumbers);
    }

    private void validate(List<Integer> ballNumbers) {
        if (Objects.isNull(ballNumbers)) {
            throw new IllegalArgumentException(BALL_NUMBERS_IS_NULL_EXCEPTION_STATEMENT);
        }
        if (ballNumbers.size() != BALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException(BALL_NUMBERS_SIZE_EXCEPTION_STATEMENT);
        }
        if (containsDuplication(ballNumbers)) {
            throw new IllegalArgumentException(BALL_NUMBERS_DUPLICATION_EXCEPTION_STATEMENT);
        }
    }

    private static void validateString(String ballNumbersString) {
        if (Objects.isNull(ballNumbersString) || ballNumbersString.isEmpty()) {
            throw new IllegalArgumentException(BALL_NUMBERS_IS_NULL_EXCEPTION_STATEMENT);
        }
    }

    private boolean containsDuplication(List<Integer> ballNumbers) {
        Set<Integer> ballNumbersSet = new HashSet<>(ballNumbers);
        return ballNumbersSet.size() != BALL_NUMBERS_SIZE;
    }

    public List<BallNumber> toList() {
        return ballNumbers;
    }
}
