package point_calculator.calculator;

import point_calculator.domain.Point;

import java.util.List;

public class TriangleCalculator extends Calculator {

    public TriangleCalculator(List<Point> points) {
        super(points);
    }

    @Override
    public double calculate() {
        return calculateArea(getPoints().get(0), getPoints().get(1), getPoints().get(2));
    }

    @Override
    public void print() {
        System.out.println("삼각형의 넓이는 " + calculate() + "입니다.");
    }

    private double calculateArea(Point point, Point point1, Point point2) {
        double a = distance(point, point1);
        double b = distance(point1, point2);
        double c = distance(point2, point);
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
