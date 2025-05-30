package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @Test
    @DisplayName("공백을 기준으로 문자열을 분리한다.")
    void split_Test(){
        //given
        String parameter = "2 + 3 * 4 / 2";

        //when
        String[] result = calculator.split(parameter);

        //then
        assertThat(result).containsExactly(
                "2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    @DisplayName("문자열 배열을 전달받아 계산을 수행한 결과를 반환한다.")
    void calculate_Test(){
        //given
        String parameter = "2 + 3 * 4 / 2";
        String[] splitResult = calculator.split(parameter);

        //when
        int calculatedResult = calculator.calculate(splitResult);

        //then
        assertThat(calculatedResult).isEqualTo(10);
    }
}