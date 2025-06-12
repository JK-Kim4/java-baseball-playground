package baseball;

import java.util.Objects;

public class BallPosition {

    private final int position;

    public BallPosition(int position) {

        if (position < 1 || position > 3) {
            throw new IllegalArgumentException("순서는 1이상 3이하의 자연수만 입력 가능");
        }

        this.position = position;
    }

    public static BallPosition of(int position){
        return new BallPosition(position);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BallPosition)) return false;
        BallPosition that = (BallPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}