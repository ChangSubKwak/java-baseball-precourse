package baseball.view;

public class ResultView {
    private static final String OUTPUT_STRIKE_COUNT = "%d스트라이크 ";
    private static final String OUTPUT_BALL_COUNT = "%d볼";
    private static final String OUTPUT_NOTHING = "낫싱";
    private static final String OUTPUT_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    private static final String OUTPUT_ERROR_MESSAGE = "[ERROR] %s 다시 입력해주세요.";

    public void outputResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(OUTPUT_NOTHING);
            return;
        }
        outputStrikeCount(strikeCount);
        outputBallCount(ballCount);
        System.out.print(System.lineSeparator());
        outputGameEnd(strikeCount);
    }

    private void outputStrikeCount(int strikeCount) {
        if (strikeCount > 0) {
            System.out.printf(OUTPUT_STRIKE_COUNT, strikeCount);
        }
    }

    private void outputBallCount(int ballCount) {
        if (ballCount > 0) {
            System.out.printf(OUTPUT_BALL_COUNT, ballCount);
        }
    }

    private void outputGameEnd(int strikeCount) {
        if (strikeCount == 3) {
            System.out.println(OUTPUT_GAME_END);
        }
    }

    public void outputErrorMessage(String message) {
        System.out.printf(OUTPUT_ERROR_MESSAGE, message);
        System.out.print(System.lineSeparator());
    }
}
