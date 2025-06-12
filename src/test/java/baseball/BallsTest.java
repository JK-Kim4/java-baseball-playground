package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(Arrays.asList(1,2,3));
    }

    @Test
    void play_nothing_3(){
        GameResult gameResult = balls.play(Arrays.asList(4,5,6));

        assertThat(gameResult.getNothings()).isEqualTo(3);
    }


    @Test
    void play_strike_2_nothing_1(){
        GameResult gameResult = balls.play(Arrays.asList(1,2,9));

        assertThat(gameResult.getStrikes()).isEqualTo(2);
        assertThat(gameResult.getBalls()).isEqualTo(0);
        assertThat(gameResult.getNothings()).isEqualTo(1);
    }

    @Test
    void play_strike_1_ball_1(){
        GameResult gameResult = balls.play(Arrays.asList(1,3,9));

        assertThat(gameResult.getStrikes()).isEqualTo(1);
        assertThat(gameResult.getBalls()).isEqualTo(1);
    }

    @Test
    void play_strike_3(){
        GameResult gameResult = balls.play(Arrays.asList(1,2,3));

        assertThat(gameResult.getStrikes()).isEqualTo(3);
    }

    @Test
    void play_each_ball(){
        Ball userBall = new Ball(BallNumber.of(1), BallPosition.of(2));
        assertThat(balls.play(userBall)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void play_each_strike(){
        Ball userBall = new Ball(BallNumber.of(1), BallPosition.of(1));
        assertThat(balls.play(userBall)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void play_each_nothing(){
        Ball userBall = new Ball(BallNumber.of(9), BallPosition.of(1));
        assertThat(balls.play(userBall)).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("볼의 개수가 3개가 아닐 경우 예외 발생")
    void create_fail_size(){
        assertThatThrownBy(() -> new Balls(Arrays.asList(1,2))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Balls(Arrays.asList(1,2,3,4))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되는 볼 넘버가 존재할 경우 예외 발생")
    void create_fail_same_number(){
        assertThatThrownBy(() -> new Balls(Arrays.asList(1,1,3))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("서로 다른 3개의 볼 넘버를 전달받아 Balls 생성")
    void create(){
        Balls balls = new Balls(Arrays.asList(1,2,3));
        assertThat(balls.size()).isEqualTo(3);
    }

}
