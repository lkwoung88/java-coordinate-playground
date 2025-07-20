package model;

import java.util.List;

public abstract class AbstractFigure implements Figure {

    private Coordinates coordinates;

    public AbstractFigure(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean hasPoint(int x, int y){
        return coordinates.getCoordinates().stream()
                .anyMatch(coordinate -> coordinate.isSame(x, y));
    }

    protected List<Coordinate> getCoordinates() {
        return this.coordinates.getCoordinates();
    }
}
