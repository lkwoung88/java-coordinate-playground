package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class TriangleTest {

    private Triangle triangle;

    @BeforeEach
    void setUp() {
        Coordinates coordinates = new Coordinates(
                List.of(
                        new Coordinate(1, 1),
                        new Coordinate(2, 10),
                        new Coordinate(7, 5)
                )
        );
        triangle = new Triangle(coordinates);
    }

    @AfterEach
    void tearDown() {
        triangle = null;
    }

    @DisplayName("삼각형의 넓이를 구한다.")
    @Test
    void getTriangleArea(){
        assertThat(triangle.calculateArea()).isEqualTo(25.000, offset(0.00099));
    }

    @DisplayName("")
    @Test
    void hasCoordinates(){
        assertThat(triangle.hasPoint(1, 1)).isTrue();
        assertThat(triangle.hasPoint(2, 10)).isTrue();
        assertThat(triangle.hasPoint(7, 5)).isTrue();
        assertThat(triangle.hasPoint(3, 3)).isFalse();
    }
}