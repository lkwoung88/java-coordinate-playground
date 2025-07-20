package view;

import model.Coordinate;
import model.Figure;

public class OutputView {
    private static final String FOUR_BLANK = "    ";
    private static final String VERTICAL_AXIS = "|";
    private static final String ORIGIN = "+";
    private static final String HORIZONTAL_AXIS = "----";
    private static final String MARK_OF_POINT = ".";

    public OutputView() {
    }

    public void showCoordinatePlane(Figure figure) {
        showVerticalNumbersWith(figure);
        showHorizontalAxis();
        showHorizontalNumbers();
    }

    private void showVerticalNumbersWith(Figure figure) {
        for(int y = Coordinate.UPPER_LINIT; y >= Coordinate.LOWER_LIMIT; y--) {
            printXAxisLine(y);
            printCoordinates(figure, y);
            emptyLine();
        }
    }

    private void printXAxisLine(int y) {
        if(y % 2 == 0){
            System.out.printf("%4d" + VERTICAL_AXIS, y);
        }
        else {
            System.out.print(FOUR_BLANK + VERTICAL_AXIS);
        }
    }

    private void printCoordinates(Figure figure, int y) {
        for(int x = Coordinate.LOWER_LIMIT; x <= Coordinate.UPPER_LINIT; x++) {
            printCoordinate(figure, y, x);
        }
    }

    private void printCoordinate(Figure figure, int y, int x) {
        if(figure.hasPoint(x, y)) {
            System.out.print(MARK_OF_POINT);
        } else {
            System.out.print(FOUR_BLANK);
        }
    }

    private void showHorizontalAxis() {
        System.out.print(FOUR_BLANK + ORIGIN);
        for(int x = Coordinate.LOWER_LIMIT; x <= Coordinate.UPPER_LINIT; x++) {
            System.out.print(HORIZONTAL_AXIS);
        }
        emptyLine();
    }

    private void showHorizontalNumbers() {
        for(int x = 0; x <= Coordinate.UPPER_LINIT; x++) {
            printYAxis(x);
        }
        emptyLine();
    }

    private void printYAxis(int x) {
        if(x % 2 == 0) {
            System.out.printf("%4d", x);
        } else {
            System.out.print(FOUR_BLANK);
        }
    }

    private void emptyLine() {
        System.out.println();
    }

    public void showArea(Figure figure) {
        System.out.println(figure.getAreaInfo());
    }
}
