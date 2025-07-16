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
}
