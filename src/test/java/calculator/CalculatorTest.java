package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @Test
    @DisplayName("공백을 기준으로 문자열을 분리한다.")
    void split_Test(){
        //given
        Calculator calculator = new Calculator();
        String parameter = "2 + 3 * 4 / 2";

        //when
        String[] result = calculator.split(parameter);

        //then
        assertThat(result).containsExactly(
                "2", "+", "3", "*", "4", "/", "2");
    }
}