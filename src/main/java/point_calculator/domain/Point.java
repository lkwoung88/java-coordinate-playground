package point_calculator.domain;

import static point_calculator.config.Properties.*;

public class Point {

    private final int x;
    private final int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point create(int x, int y) {
        if (isNotAvailablePoint(x, y)) {
            throw new IllegalArgumentException("좌표는 0에서 24 사이의 값이어야 합니다.");
        }
        return new Point(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private static boolean isNotAvailablePoint(int x, int y) {
        return x < MIN_ROW_SIZE || x > MAX_ROW_SIZE || y < MIN_COLUMN_SIZE || y > MAX_COLUMN_SIZE;
    }
}
