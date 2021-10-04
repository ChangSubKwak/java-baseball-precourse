package baseball.view;

import java.util.Arrays;

import nextstep.utils.Console;

public class InputView {
    private static final String INPUT_BALL_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String INPUT_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_ERROR = "[ERROR] 잘못된 값을 입력하였습니다. 다시 입력하세요.";
    private static final String INPUT_CONTINUE_SYMBOL = "1";
    private static final String INPUT_END_SYMBOL = "2";

    public String inputBallNumbers() {
        System.out.print(INPUT_BALL_NUMBERS);
        return Console.readLine();
    }

    public boolean inputRetry() {
        System.out.println(INPUT_RETRY);
        String answer = Console.readLine();
        while (!Arrays.asList(INPUT_CONTINUE_SYMBOL, INPUT_END_SYMBOL).contains(answer)) {
            System.out.println(INPUT_ERROR);
            answer = Console.readLine();
        }
        return answer.equals(INPUT_CONTINUE_SYMBOL);
    }
}
