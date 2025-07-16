package point_calculator.calculator;

import point_calculator.domain.Point;

import java.util.List;

public abstract class Calculator {

    private List<Point> points;

    public Calculator(List<Point> points) {
        this.points = points;
    }

    public abstract double calculate();

    public abstract void print();

    public List<Point> getPoints() {
        return points;
    }

    protected double distance(Point point, Point point1) {
        return Math.sqrt(Math.pow(point.getX() - point1.getX(), 2) + Math.pow(point.getY() - point1.getY(), 2));
    }
}
