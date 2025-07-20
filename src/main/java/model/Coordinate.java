package model;

public class Coordinate {
    public static final int UPPER_LINIT = 24;
    public static final int LOWER_LIMIT = 1;

    public static final String COORDINATE_RANGE_ERROR_MESSAGE = "좌표는 최소 "+ LOWER_LIMIT + "부터 최대 " + UPPER_LINIT + "까지만 입력할 수 있습니다.";

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        if (x < LOWER_LIMIT || x > UPPER_LINIT || y < LOWER_LIMIT || y > UPPER_LINIT) {
            throw new IllegalArgumentException(COORDINATE_RANGE_ERROR_MESSAGE);
        }
        this.x = x;
        this.y = y;
    }

    public boolean isSame(int x, int y) {
        return this.x == x && this.y == y;
    }

    public double distanceTo(Coordinate other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
