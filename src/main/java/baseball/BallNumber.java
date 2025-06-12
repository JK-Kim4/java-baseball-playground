package baseball;

import java.util.Objects;

public class BallNumber {

    private final int number;

    public BallNumber(int number) {

        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("순서는 1이상 9이하의 자연수만 입력 가능");
        }

        this.number = number;

    }

    public static BallNumber of(int number){
        return new BallNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BallNumber)) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
