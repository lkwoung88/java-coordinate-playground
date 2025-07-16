package point_calculator.factory;

import point_calculator.calculator.Calculator;
import point_calculator.calculator.LineCalculator;
import point_calculator.calculator.RectangleCalculator;
import point_calculator.calculator.TriangleCalculator;
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
        if (points.size() == 4) {
            return new RectangleCalculator(points);
        }
        if( points.size() == 3) {
            return new TriangleCalculator(points);
        }
        throw new IllegalArgumentException("Unsupported number of points for calculation: " + points.size());
    }
}
