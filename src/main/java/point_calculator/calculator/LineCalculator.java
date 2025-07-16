package point_calculator.calculator;

import point_calculator.domain.Point;

import java.util.List;

public class LineCalculator implements Calculator {

    @Override
    public double calculate(List<Point> points) {
        return calculateDistance(points.get(0), points.get(1));
    }

    private double calculateDistance(Point x, Point y) {
        return Math.sqrt(Math.pow(x.getX() - y.getX(), 2) + Math.pow(x.getY() - y.getY(), 2));
    }
}
