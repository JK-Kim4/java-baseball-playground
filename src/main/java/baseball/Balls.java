package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        if(hasDuplicate(numbers)){
            throw new IllegalArgumentException("볼 넘버는 중복될 수 없습니다.");
        }

        if(numbers.size() != 3) {
            throw new IllegalArgumentException("볼의 개수는 3개여야 합니다.");
        }

        this.balls = mapBalls(numbers);
    }

    private static List<Ball> mapBalls(List<Integer> numbers) {
        int index = 1;
        List<Ball> ballList = new ArrayList<>();
        for(Integer number : numbers) {
            ballList.add(new Ball(BallNumber.of(number), BallPosition.of(index++)));
        }
        return ballList;
    }

    public static boolean hasDuplicate(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    public BallStatus play(Ball userBall) {
        return balls.stream()
                .map(computerBall -> computerBall.compare(userBall))
                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public GameResult play(List<Integer> userNumbers) {
        GameResult result = new GameResult();
        Balls userBalls = new Balls(userNumbers);
        for(Ball userBall: userBalls.balls){
            BallStatus status = this.play(userBall);
            result.report(status);
        }


        return result;
    }

    public int size() {
        return balls.size();
    }
}
