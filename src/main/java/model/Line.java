package model;

public class Line extends AbstractFigure {

    public Line(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getName() {
        return "Line";
    }

    @Override
    public double calculateArea() {
        return 0; // A line has no area
    }

    public double calculateDistance() {
        return getCoordinates().get(0).distanceTo(getCoordinates().get(1));
    }

    @Override
    public String getAreaInfo() {
        return "두 점 사이의 거리는 " + getCoordinates().get(0).distanceTo(getCoordinates().get(1)) + "입니다.";
    }
}
