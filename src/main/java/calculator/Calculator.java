package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("계산하실 연산을 입력해주세요.");
        String string = scanner.nextLine();

        String[] split = calculator.split(string);

        int calculateResult = calculator.calculate(split);

        System.out.println("연산 결과: "+calculateResult);
    }

    public String[] split(String input){
        return input.split(" ");
    }

    public int calculate(String[] input){
        int result = 0;
        Queue<String> inputQueue = new LinkedList<>(Arrays.asList(input));

        while (!inputQueue.isEmpty()){
            switch (inputQueue.peek()){
                case "+":
                    inputQueue.remove();
                    result += Integer.parseInt(inputQueue.remove());
                    break;
                case "-":
                    inputQueue.remove();
                    result -= Integer.parseInt(inputQueue.remove());
                    break;
                case "*":
                    inputQueue.remove();
                    result *= Integer.parseInt(inputQueue.remove());
                    break;
                case "/":
                    inputQueue.remove();
                    result /= Integer.parseInt(inputQueue.remove());
                    break;
                default:
                    result = Integer.parseInt(inputQueue.remove());
                    break;
            }
        }

        return result;
    }

    private boolean isOperator(String peek) {
        return  peek.equals("+") ||
                peek.equals("-") ||
                peek.equals("*") ||
                peek.equals("/");
    }
}
