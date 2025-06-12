package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumberTest {

    @Test
    public void 순서_1이상_3이하(){
        assertThat(new BallNumber(1)).isNotNull();
        assertThatThrownBy(() -> new BallNumber(0)).isInstanceOf(IllegalArgumentException.class);
        assertThat(new BallNumber(3)).isNotNull();
        assertThatThrownBy(() -> new BallNumber(4)).isInstanceOf(IllegalArgumentException.class);
    }

}