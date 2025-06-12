package baseball;

public class GameResult {

    private int strikes;
    private int balls;
    private int nothings;

    public void addStrike() {
        strikes++;
    }

    public void addBall() {
        balls++;
    }

    public void addNothing() {
        nothings++;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls(){
        return balls;
    }

    public int getNothings() {
        return nothings;
    }

    public void report(BallStatus status) {
        if(status.isStrike()){
            addStrike();
            return;
        }

        if (status.isBall()) {
            addBall();
            return;
        }

        addNothing();
    }
}
