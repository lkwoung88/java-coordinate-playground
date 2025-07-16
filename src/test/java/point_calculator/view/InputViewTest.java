package point_calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import point_calculator.domain.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    @DisplayName("(10,10)-(14,15) 형식의 좌표를 입력하면 올바르게 파싱된다.")
    @Test
    void getPointsTest(){

        // given
        String input = "(10,10)-(14,15)";
        InputView inputView = new InputView();

        // when
        List<Point> points = inputView.parsePoints(input);

        // then
        assertThat(points).hasSize(2);
    }

    @DisplayName("X, Y좌표 모두 최대 24까지만 입력할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "(25,10)-(14,15)",
            "(10,25)-(14,15)",
            "(10,10)-(25,15)",
            "(10,10)-(14,25)"
    })
    void failParsingPoints(String input) {
        // given
        InputView inputView = new InputView();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.parsePoints(input);
        });
    }
}