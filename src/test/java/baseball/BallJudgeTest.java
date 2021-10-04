package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.domain.BallJudge;
import baseball.domain.BallJudgeResult;
import baseball.domain.BallNumbers;

class BallJudgeTest {
    private BallJudge ballJudge;

    private static Stream<Arguments> judgeTest() {
        return Stream.of(
            Arguments.of("713", "123", BallJudgeResult.from(1, 1)),
            Arguments.of("713", "145", BallJudgeResult.from(0, 1)),
            Arguments.of("713", "671", BallJudgeResult.from(0, 2)),
            Arguments.of("713", "216", BallJudgeResult.from(1, 0)),
            Arguments.of("713", "624", BallJudgeResult.from(0, 0)),
            Arguments.of("713", "713", BallJudgeResult.from(3, 0))
        );
    }

    @BeforeEach
    void setUp() {
        ballJudge = new BallJudge();
    }

    @DisplayName("judge 상대방볼의 수와 사용자가 입력하는 수가 주어진다면, 매칭된는 스트라이크와 볼의 개수를 가진 BallJudgeResult객체를 반환한다")
    @ParameterizedTest
    @MethodSource
    void judgeTest(String computerBallNumbers, String humanBallNumbers, BallJudgeResult expected) {
        assertThat(
            ballJudge.judge(BallNumbers.from(computerBallNumbers), BallNumbers.from(humanBallNumbers))).isEqualTo(
            expected);
    }

    @DisplayName(" 스트라이크가 3개에 해당하는 데이터를 인자로 받아 judge를 호출후, 게임 종료여부 함수를 호출하면 참을 얻는다")
    @Test
    void isGameEndTest() {
        ballJudge.judge(BallNumbers.from("123"), BallNumbers.from("123"));
        assertThat(ballJudge.isGameEnd()).isTrue();
    }
}
