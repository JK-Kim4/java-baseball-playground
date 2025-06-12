package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    public void strike(){
        Ball com = new Ball(BallNumber.of(1), BallPosition.of(1));
        assertThat(com.compare(new Ball(BallNumber.of(1), BallPosition.of(1)))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    public void ball(){
        Ball com = new Ball(BallNumber.of(1), BallPosition.of(3));
        assertThat(com.compare(new Ball(BallNumber.of(1), BallPosition.of(2)))).isEqualTo(BallStatus.BALL);
    }

    @Test
    public void nothing(){
        Ball com = new Ball(BallNumber.of(1), BallPosition.of(1));
        assertThat(com.compare(new Ball(BallNumber.of(2), BallPosition.of(1)))).isEqualTo(BallStatus.NOTHING);
    }

}
