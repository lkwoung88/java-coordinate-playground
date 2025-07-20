package model;

import java.util.List;

public class Triangle extends AbstractFigure{

    public Triangle(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public double calculateArea() {
        double a = getCoordinates().get(0).distanceTo(getCoordinates().get(1));
        double b = getCoordinates().get(1).distanceTo(getCoordinates().get(2));
        double c = getCoordinates().get(2).distanceTo(getCoordinates().get(0));
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String getAreaInfo() {
        return "";
    }
}
