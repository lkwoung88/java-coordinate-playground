package view;

import model.Coordinates;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    
    @DisplayName("좌표 정보는 괄호\"(\", \")\"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.")
    @Test
    void makeCoordinatesByUserInput(){
    
        // given
        String userInput = "(10,10)-(14,15)";
        InputView inputView = new InputView();

        // when
        Coordinates coordinates = inputView.extractCoordinateListBy(userInput);
    
        // then
        assertThat(coordinates.getCoordinates())
                .extracting("x", "y")
                .containsExactlyInAnyOrder(
                        tuple(10, 10),
                        tuple(14, 15)
                );
    }

    @DisplayName("X, Y좌표 모두 최대 24까지만 입력할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "(25,10)-(14,15)",
            "(10,25)-(14,15)",
            "(25,25)-(14,15)",
            "(10,10)-(25,25)",
            "(0,10)-(14,15)",
            "(10,0)-(14,15)",
            "(0,0)-(14,15)",
            "(10,10)-(0,0)",
            "(10,10)-(25,0)",
            "(10,10)-(0,25)",
    })
    void inputCoordinateShouldNotExceedMaxValue(){

        // given
        String userInput = "(25,10)-(14,15)";
        InputView inputView = new InputView();

        // when
        // then
        assertThatThrownBy(() -> inputView.extractCoordinateListBy(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("좌표는 최소 1부터 최대 24까지만 입력할 수 있습니다.");
    }
}