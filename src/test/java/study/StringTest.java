package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split1(){
        String parameter = "1,2";
        String[] result = parameter.split(",");

        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring(){
        String parameter = "(1,2)";
        String result = parameter.substring(1, parameter.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("전달받은 문자열의 인덱스에 해당하는 문자를 가져온다. (문자열의 길이를 벗어난 인덱스 조회의 경우 StringIndexOutOfBoundsException).")
    void charAt(){
        //given
        String parameter = "abc";
        int targetIndex = 0;
        int outOfLangeIndex = parameter.length() + 100;

        //when
        char indexChar = parameter.charAt(targetIndex);;


        assertThat('a').isEqualTo(indexChar);
        assertThatThrownBy( () -> parameter.charAt(outOfLangeIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
