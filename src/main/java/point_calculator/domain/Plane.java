package point_calculator.domain;

import java.util.List;

import static point_calculator.config.Properties.MAX_COLUMN_SIZE;
import static point_calculator.config.Properties.MAX_ROW_SIZE;

public class Plane {

    private static final String SPACE = "  ";
    private static final String AXIS_BAR = "|";
    private static final String X_AXIS_LINE = "---";
    public static final String MARK = "*";

    public static final int PLANE_ROW_SIZE = MAX_ROW_SIZE + 1;
    public static final int PLANE_COLUMN_SIZE = MAX_COLUMN_SIZE + 1;

    private final String[][] plane;

    private Plane() {
        this.plane = new String[PLANE_ROW_SIZE][PLANE_COLUMN_SIZE];
        initializePlane();
    }

    public static Plane create() {
        return new Plane();
    }

    public void markPoints(List<Point> points) {
        for (Point point : points) {
            this.plane[point.getY()][point.getX()] = String.format("%2s", MARK);
        }
    }

    public void print() {
        printBody();
        printXAxisLine();
        printXAxisLabel();
    }

    private void initializePlane() {
        for (int row = PLANE_ROW_SIZE - 1; row > 0; row--) {
            initializeYAxis(row);
        }
        for (int column = 0; column < PLANE_COLUMN_SIZE; column++) {
            initializeXAxis(column);
        }
    }

    private void initializeYAxis(int row) {
        if (row % 2 == 0) {
            plane[row][0] = String.format("%2d", row);
            return;
        }
        plane[row][0] = SPACE;
    }

    private void initializeXAxis(int column) {
        if (column == 0) {
            plane[0][column] = String.format("%d", 0);
            return;
        }
        if (column % 2 == 0) {
            plane[0][column] = String.format("%4d", column);
            return;
        }
        plane[0][column] = SPACE;
    }

    private void printBody() {
        for (int i = PLANE_ROW_SIZE - 1; i > 0; i--) {
            printRows(i);
        }
    }

    private void printRows(int i) {
        for (int j = 0; j < PLANE_COLUMN_SIZE; j++) {
            System.out.print(printYAxisLine(i, j));
        }
        System.out.println();
    }

    private String printYAxisLine(int i, int j) {
        if (j == 0) {
            return plane[i][j] + AXIS_BAR;
        }
        if (plane[i][j] == null) {
            return SPACE;
        }
        return plane[i][j];
    }

    private void printXAxisLine() {
        System.out.print("  +");
        for (int i = 1; i < PLANE_COLUMN_SIZE; i++) {
            System.out.print(X_AXIS_LINE);
        }
        System.out.println();
    }

    private void printXAxisLabel() {
        for (int i = 0; i < PLANE_COLUMN_SIZE; i++) {
            System.out.print(plane[0][i] == null ? SPACE : plane[0][i]);
        }
    }
}