package point_calculator.factory;

import point_calculator.calculator.Calculator;
import point_calculator.calculator.LineCalculator;
import point_calculator.domain.Point;

import java.util.List;

public class CalculatorFactory {

    private CalculatorFactory() {
        // Prevent instantiation
    }

    public static Calculator createCalculator(List<Point> points) {
        if (points.size() == 2) {
            return new LineCalculator(points);
        }
        throw new IllegalArgumentException("Unsupported number of points for calculation: " + points.size());
    }
}
