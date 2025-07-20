package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoordinateTest {

    @DisplayName("좌표를 생성한다.")
    @Test
    void createCoordinate() {

        // given
        int x = 1;
        int y = 2;

        // when
        Coordinate coordinate = new Coordinate(x, y);

        // then
        assertThat(coordinate.getX()).isEqualTo(x);
        assertThat(coordinate.getY()).isEqualTo(y);
    }

    @DisplayName("좌표 생성 시 x, y 값이 1 이상 24 이하가 아니면 예외를 발생시킨다.")
    @Test
    void createCoordinateException(){

        // given
        int x1 = 0;
        int y1 = 10;

        int x2 = 10;
        int y2 = 25;

        // when
        // then

        assertThatThrownBy(() -> new Coordinate(x1, y1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("좌표는 최소 1부터 최대 24까지만 입력할 수 있습니다.");
        assertThatThrownBy(() -> new Coordinate(x2, y2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("좌표는 최소 1부터 최대 24까지만 입력할 수 있습니다.");
    }

    @DisplayName("두 점 사이의 거리를 계산한다.")
    @Test
    void getDistance(){

        // given
        Coordinate coordinate1 = new Coordinate(1, 2);
        Coordinate coordinate2 = new Coordinate(4, 6);

        // when
        double distance = coordinate1.distanceTo(coordinate2);

        // then
        assertThat(distance).isEqualTo(5.0);
    }

}