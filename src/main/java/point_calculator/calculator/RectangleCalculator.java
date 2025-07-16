package point_calculator.calculator;

import point_calculator.domain.Point;

import java.util.List;

public class RectangleCalculator extends Calculator {

    public RectangleCalculator(List<Point> points) {
        super(points);
        if(!isRectangle(points)) {
            throw new IllegalArgumentException("주어진 점들은 사각형을 형성하지 않습니다.");
        }
    }

    @Override
    public double calculate() {
        double width = distance(getPoints().get(0), getPoints().get(1));
        double height = distance(getPoints().get(1), getPoints().get(2));
        return width * height;
    }

    @Override
    public void print() {
        System.out.println("사각형의 넓이는 " + calculate() + "입니다.");
    }


    private double distance(Point point, Point point1) {
        return Math.sqrt(Math.pow(point.getX() - point1.getX(), 2) + Math.pow(point.getY() - point1.getY(), 2));
    }

    private boolean isRectangle(List<Point> points) {
        Point a = points.get(0);
        Point b = points.get(1);
        Point c = points.get(2);
        Point d = points.get(3);

        return isRightAngle(a, b, c) &&
                isRightAngle(b, c, d) &&
                isRightAngle(c, d, a) &&
                isRightAngle(d, a, b);
    }

    private boolean isRightAngle(Point p1, Point p2, Point p3) {
        int dx1 = p1.getX() - p2.getX();
        int dy1 = p1.getY() - p2.getY();
        int dx2 = p3.getX() - p2.getX();
        int dy2 = p3.getY() - p2.getY();
        return dx1 * dx2 + dy1 * dy2 == 0;
    }
}
