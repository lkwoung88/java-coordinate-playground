package point_calculator.calculator;

import point_calculator.domain.Point;

import java.util.List;

public class LineCalculator extends Calculator {

    public LineCalculator(List<Point> points) {
        super(points);
    }

    @Override
    public double calculate() {
        return calculateDistance(getPoints().get(0), getPoints().get(1));
    }

    @Override
    public void print() {
        System.out.println("직선의 길이는 " + calculate() + "입니다.");
    }

    private double calculateDistance(Point x, Point y) {
        return Math.sqrt(Math.pow(x.getX() - y.getX(), 2) + Math.pow(x.getY() - y.getY(), 2));
    }
}
