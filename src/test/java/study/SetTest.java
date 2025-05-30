package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int parameter) {
        assertThat(numbers.contains(parameter)).isTrue();
    }



    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5"}, delimiter = ',')
    void parameterizedTest(int true1, int true2, int true3, int false1, int false2) {
        assertThat(numbers.contains(true1)).isTrue();
        assertThat(numbers.contains(true2)).isTrue();
        assertThat(numbers.contains(true3)).isTrue();
        assertThat(numbers.contains(false1)).isFalse();
        assertThat(numbers.contains(false2)).isFalse();
    }


}
