package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FigureFactoryTest {

    @DisplayName("null 입력 시 예외 발생")
    @Test
    void nullInputException(){

        // given
        Coordinates coordinates = null;

        // when
        // then
        assertThatThrownBy(() -> FigureFactory.createFigures(coordinates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("좌표는 null일 수 없습니다.");
    }

    @DisplayName("좌표는 2개이상 4개 이하로 입력해야 한다.")
    @Test
    void throwsExceptionWhenCoordinatesAreLessThanTwo(){
    
        // given
        Coordinates coordinates = new Coordinates(List.of(
                new Coordinate(1, 1)
        ));
    
        // when
        // then
        assertThatThrownBy(() -> FigureFactory.createFigures(coordinates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 Point 개수가 유효하지 않습니다.");
    }

    @DisplayName("좌표는 2개이상 4개 이하로 입력해야 한다.")
    @Test
    void throwsExceptionWhenCoordinatesAreMoreThanFour(){

        // given
        Coordinates coordinates = new Coordinates(List.of(
                new Coordinate(1, 1),
                new Coordinate(2, 2),
                new Coordinate(3, 3),
                new Coordinate(4, 4),
                new Coordinate(5, 5)
        ));

        // when
        // then
        assertThatThrownBy(() -> FigureFactory.createFigures(coordinates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 Point 개수가 유효하지 않습니다.");
    }
    
    @DisplayName("좌표 두개로 선분을 생성한다.")
    @Test
    void creteLine(){

        // given
        Coordinates coordinates = new Coordinates(List.of(
                new Coordinate(1, 1),
                new Coordinate(2, 2)
        ));

        // when
        Figure figure = FigureFactory.createFigures(coordinates);

        // then
        assertThat(figure).isInstanceOf(Line.class);
    }
    
    @DisplayName("좌표 네개로 사각형을 생성한다.")
    @Test
    void createRectangle(){
    
        // given
        Coordinates coordinates = new Coordinates(List.of(
                new Coordinate(1, 1),
                new Coordinate(1, 4),
                new Coordinate(4, 4),
                new Coordinate(4, 1)
        ));
    
        // when
        Figure figure = FigureFactory.createFigures(coordinates);
    
        // then
        assertThat(figure).isInstanceOf(Rectangle.class);
    }

    @DisplayName("좌표 세개로 삼각형을 생성한다.")
    @Test
    void createTriangle(){
    
        // given
        Coordinates coordinates = new Coordinates(List.of(
                new Coordinate(1, 1),
                new Coordinate(2, 3),
                new Coordinate(4, 1)
        ));
    
        // when
        Figure figure = FigureFactory.createFigures(coordinates);
    
        // then
        assertThat(figure).isInstanceOf(Triangle.class);
    }
}