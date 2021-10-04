package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.BallJudgeResult;

class BallJudgeResultTest {
    @DisplayName("정적팩터리 메서드 from을 이용하여 객체를 생성하면 BallJudgeResult객체를 반환한다")
    @Test
    void createTest() {
        assertThat(BallJudgeResult.from(0, 0)).isInstanceOf(BallJudgeResult.class);
    }

    @DisplayName("스트라이크의 개수가 범위를 벗어나면, 예외를 던진다")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> BallJudgeResult.from(-1, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BallJudgeResult.from(4, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("볼의 개수가 범위를 벗어나면, 예외를 던진다")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> BallJudgeResult.from(0, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BallJudgeResult.from(0, 4)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("increaseStrike함수를 호출하면, 스트라이크의 개수가 하나 증가한다")
    @Test
    void increaseStrikeTest() {
        BallJudgeResult ballJudgeResult = BallJudgeResult.from(0, 0);
        ballJudgeResult = ballJudgeResult.increaseStrike();
        assertThat(ballJudgeResult.strikeCount()).isEqualTo(1);
    }

    @DisplayName("increaseBall함수를 호출하면, 볼의 개수가 하나 증가한다")
    @Test
    void increaseBallTest() {
        BallJudgeResult ballJudgeResult = BallJudgeResult.from(0, 0);
        ballJudgeResult = ballJudgeResult.increaseBall();
        assertThat(ballJudgeResult.ballCount()).isEqualTo(1);
    }
}
