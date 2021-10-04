package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.BallNumber;
import baseball.domain.BallNumbers;

class BallNumbersTest {
    @DisplayName("정적팩터리 메서드 from을 이용하여 객체를 생성하면 BallNumbers객체를 반환한다")
    @Test
    void createTest() {
        assertThat(BallNumbers.from(Arrays.asList(1, 2, 3))).isInstanceOf(BallNumbers.class);
    }

    @DisplayName("정적팩터리 메서드 from의 인자가 null또는 \"\"이면 예외가 발생한다")
    @Test
    void exceptionTest1() {
        String inputString = null;
        assertThatThrownBy(() -> BallNumbers.from(inputString)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BallNumbers.from("")).isInstanceOf(IllegalArgumentException.class);
        List<Integer> inputList = null;
        assertThatThrownBy(() -> BallNumbers.from(inputList)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정적팩터리 메서드 from의 인자인 BallNumbers의 정해진 크기인 3보다 작다면 예외가 발생한다")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> BallNumbers.from(Arrays.asList(1, 2))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정적팩터리 메서드 from의 인자인 BallNumbers의 정해진 크기인 3보다 크다면 예외가 발생한다")
    @Test
    void exceptionTest3() {
        assertThatThrownBy(() -> BallNumbers.from(Arrays.asList(1, 2, 3, 4))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정적팩터리 메서드 from의 인자인 BallNumber의 원소가 중복된다면 예외가 발생한다")
    @Test
    void exceptionTest4() {
        assertThatThrownBy(() -> BallNumbers.from(Arrays.asList(1, 1, 2))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BallNumbers.from(Arrays.asList(2, 1, 1))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BallNumbers.from(Arrays.asList(1, 2, 1))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BallNumbers.from(Arrays.asList(1, 1, 1))).isInstanceOf(IllegalArgumentException.class);
    }
}
