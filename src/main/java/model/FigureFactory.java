package model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {

    private static final String ERROR_INVALID_FIGURE_CREATION = "입력된 Point 개수가 유효하지 않습니다.";
    public static final String ERROR_INVALID_NULL_INPUT = "좌표는 null일 수 없습니다.";

    private static final int NUM_OF_VERTICES_OF_LINE = 2;
    private static final int NUM_OF_VERTICES_OF_TRIANGLE = 3;
    private static final int NUM_OF_VERTICES_OF_RECTANGLE = 4;

    private static final Map<Integer, Function<Coordinates, Figure>> classifier = new HashMap<>();

    static {
        classifier.put(NUM_OF_VERTICES_OF_LINE, Line::new);
        classifier.put(NUM_OF_VERTICES_OF_TRIANGLE, Triangle::new);
        classifier.put(NUM_OF_VERTICES_OF_RECTANGLE, Rectangle::new);
    }

    public static Figure createFigures(Coordinates coordinates) {

        if (coordinates == null) {
            throw new IllegalArgumentException(ERROR_INVALID_NULL_INPUT);
        }

        int coordinatesCount = coordinates.getCoordinatesCount();

        if (!classifier.containsKey(coordinatesCount)) {
            throw new IllegalArgumentException(ERROR_INVALID_FIGURE_CREATION);
        }

        return classifier.get(coordinatesCount).apply(coordinates);
    }
}
