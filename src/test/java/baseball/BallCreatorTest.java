package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.BallCreator;
import baseball.domain.BallNumbers;

class BallCreatorTest {
    @DisplayName("create함수를 호출하면 야구게임 규칙에 맞는 3자리 번호를 가지는 BallNumbers 클래스를 생성한다")
    @Test
    void createTest() {
        assertThat(BallCreator.create()).isInstanceOf(BallNumbers.class);
    }
}
