package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    @DisplayName("(computer)임의의 서로 다른 숫자로 이루어진 Balls 객체를 생성한다")
    void create_balls_from_computer() {
        Game game = new Game(System.in);

        game.init();

        assertThat(game.getBallsSize()).isEqualTo(3);
    }


}
