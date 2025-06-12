package baseball;

import java.util.Objects;

public class Ball {

    private final BallNumber number;
    private final BallPosition position;

    public Ball(BallNumber number, BallPosition position) {
        this.number = number;
        this.position = position;
    }

    public BallStatus compare(Ball user) {
        if(this.equals(user)){
            return BallStatus.STRIKE;
        }
        if(this.isSameNumber(user)){
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isSameNumber(Ball user) {
        return this.number.equals(user.number);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return Objects.equals(number, ball.number) && Objects.equals(position, ball.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
