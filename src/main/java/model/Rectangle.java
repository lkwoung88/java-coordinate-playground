package model;

import java.awt.*;
import java.util.List;

public class Rectangle extends AbstractFigure {

    public Rectangle(Coordinates coordinates) {
        super(coordinates);
        if (!checkRectangleWith(coordinates)) {
            throw new IllegalArgumentException("사각형이 아닙니다. 올바른 좌표를 입력하세요. (좌표를 순서대로 입력해주세요 에: A(1,1)->B(1,4)->C(5,4)->D(5,1))");
        }
    }

    private boolean checkRectangleWith(Coordinates coordinates) {
        return isRectangle(coordinates);
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public double calculateArea() {
        return getCoordinates().get(0).distanceTo(getCoordinates().get(1)) * getCoordinates().get(1).distanceTo(getCoordinates().get(2));
    }

    @Override
    public String getAreaInfo() {
        return "사각형의 넓이는 " + calculateArea() + "입니다.";
    }

    private boolean isRectangle(Coordinates coordinates) {
        List<Coordinate> coordinatesList = coordinates.getCoordinates();
        Coordinate a = coordinatesList.get(0);
        Coordinate b = coordinatesList.get(1);
        Coordinate c = coordinatesList.get(2);
        Coordinate d = coordinatesList.get(3);

        return isRightAngle(a, b, c) &&
                isRightAngle(b, c, d) &&
                isRightAngle(c, d, a) &&
                isRightAngle(d, a, b);
    }

    private boolean isRightAngle(Coordinate p1, Coordinate p2, Coordinate p3) {
        int dx1 = p1.getX() - p2.getX();
        int dy1 = p1.getY() - p2.getY();
        int dx2 = p3.getX() - p2.getX();
        int dy2 = p3.getY() - p2.getY();
        return dx1 * dx2 + dy1 * dy2 == 0;
    }
}
