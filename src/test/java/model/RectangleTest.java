package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    private Rectangle rectangle;

    @BeforeEach
    void setUp() {
        Coordinates coordinates = new Coordinates(
                List.of(
                        new Coordinate(1, 2),
                        new Coordinate(1, 4),
                        new Coordinate(3, 4),
                        new Coordinate(3, 2)
                )
        );
        rectangle = new Rectangle(coordinates);
    }

    @AfterEach
    void tearDown() {
        rectangle = null;
    }
    
    @DisplayName("직사각형이 아닌 경우 예외 발생")
    @Test
    void isNotRectangle(){
    
        // given
        Coordinates coordinates = new Coordinates(
                List.of(
                        new Coordinate(1, 2),
                        new Coordinate(2, 1),
                        new Coordinate(3, 2),
                        new Coordinate(2, 4)
                )
        );
    
        // when
        // then
        Assertions.assertThatThrownBy(() -> new Rectangle(coordinates))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("직사각형이 맞는 경우 생성 성공")
    @Test
    void isRectangle(){

        // given
        Coordinates coordinates = new Coordinates(
                List.of(
                        new Coordinate(1, 2),
                        new Coordinate(1, 4),
                        new Coordinate(3, 4),
                        new Coordinate(3, 2)
                )
        );

        // when
        Rectangle rectangle = new Rectangle(coordinates);

        // then
        assertThat(rectangle).isExactlyInstanceOf(Rectangle.class);
        assertThat(rectangle.calculateArea()).isEqualTo(4.0);
    }

    @DisplayName("좌표를 가지고 있는지 확인한다.")
    @Test
    void hasRectangleCoordinate(){
        assertTrue(rectangle.hasPoint(1, 2));
        assertTrue(rectangle.hasPoint(1, 4));
        assertTrue(rectangle.hasPoint(3, 4));
        assertTrue(rectangle.hasPoint(3, 2));
    }
}