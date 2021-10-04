package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.BallNumber;

class BallNumberTest {
    @DisplayName("정적팩터리 메서드 from을 이용하여 BallNumber객체를 생성하면 BallNumber객체가 된다")
    @Test
    void createTest() {
        assertThat(BallNumber.from(1)).isInstanceOf(BallNumber.class);
    }

    @DisplayName("정적팩터리 메서드 from의 인자가 최저범위 미만이면 예외가 발생한다")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> BallNumber.from(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정적팩터리 메서드 from의 인자가 최고범위 초과하면 예외가 발생한다")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> BallNumber.from(10)).isInstanceOf(IllegalArgumentException.class);
    }
}
