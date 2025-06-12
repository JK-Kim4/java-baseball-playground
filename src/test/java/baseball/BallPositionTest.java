package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallPositionTest {

    @Test
    public void 순서_1이상_3이하(){
        assertThat(new BallPosition(1)).isNotNull();
        assertThatThrownBy(() -> new BallPosition(0)).isInstanceOf(IllegalArgumentException.class);
        assertThat(new BallPosition(3)).isNotNull();
        assertThatThrownBy(() -> new BallPosition(4)).isInstanceOf(IllegalArgumentException.class);
    }

}