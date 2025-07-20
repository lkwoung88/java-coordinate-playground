package model;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    private Line line;

    @BeforeEach
    public void setUp() {
        line = new Line(new Coordinates(
                List.of(
                        new Coordinate(1, 1),
                        new Coordinate(2, 2)
                )
        ));
    }

    @AfterEach
    void tearDown() {
        line = null;
    }
    
    @DisplayName("주어진 좌표를 가지고 있는지 확인한다.")
    @Test
    void hasCoordinates(){
        assertTrue(line.hasPoint(1, 1));
        assertTrue(line.hasPoint(2, 2));
        assertFalse(line.hasPoint(2, 3));
    }

    @DisplayName("두 좌표의 거리를 계산한다.")
    @Test
    void getDistance(){

        // given
        // when
        double distance = line.calculateDistance();

        // then
        assertEquals(1.4142135623730951, distance, 0.00001);
    }
}