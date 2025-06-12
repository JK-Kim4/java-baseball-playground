package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallPositionTest {

    @Test
    public void 숫자_1이상_9이하(){
        assertThat(new BallPosition(1)).isNotNull();
        assertThatThrownBy(() -> new BallPosition(0)).isInstanceOf(IllegalArgumentException.class);
        assertThat(new BallPosition(9)).isNotNull();
        assertThatThrownBy(() -> new BallPosition(10)).isInstanceOf(IllegalArgumentException.class);
    }

}