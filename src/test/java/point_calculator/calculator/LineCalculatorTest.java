package point_calculator.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import point_calculator.domain.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LineCalculatorTest {

    @DisplayName("직선의 거리를 구한다.")
    @Test
    void getLineDistance(){

        // given
        List<Point> points = List.of(
                Point.create(0, 0),
                Point.create(1, 1)
        );
        LineCalculator lineCalculator = new LineCalculator();

        // when
        double line = lineCalculator.calculate(points);

        // then
        assertThat(line).isEqualTo(1.414, offset(0.00099));
    }
}