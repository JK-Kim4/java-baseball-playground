package baseball;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;
    private Balls balls;


    public Game(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
        init();
    }

    public void play(){
        GameResult result = new GameResult();

        do {
            List<Integer> userInputs = input();
            result = balls.play(userInputs);

            System.out.println(result.getStrikes() + " 스트라이크, " + result.getBalls() + " 볼, " + result.getNothings() + " 낫싱");
        } while (result.getStrikes() != 3);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }


    public void init() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = (int) (Math.random() * 9) + 1; // 1부터 9까지의 숫자
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        System.out.println(numbers);

        this.balls = new Balls(numbers);
    }

    public List<Integer> input() {
        List<Integer> numbers = new ArrayList<>();
        System.out.print("숫자를 입력하세요: ");
        String input = scanner.next();

        try {
            numbers = extracted(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return input(); // 재귀 호출로 다시 입력 받기
        }

        return numbers;
    }

    private  List<Integer> extracted(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
            }

            if (numbers.contains(Character.getNumericValue(c))){
                throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
            }

            numbers.add(Character.getNumericValue(c));
        }

        return numbers;
    }

    public int getBallsSize() {
        return this.balls.size();
    }
}
