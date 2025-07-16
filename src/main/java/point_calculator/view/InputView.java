package point_calculator.view;

import point_calculator.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<Point> requestPoints() {
        System.out.println("좌표를 입력하세요.");
        String input = scanner.nextLine();
        if (isAvailableInput(input)) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다. 예: (10,10)-(14,15)");
        }
        return parsePoints(input);
    }

    public boolean isAvailableInput(String input) {
        return !input.matches("^\\(\\d{1,2},\\d{1,2}\\)-\\(\\d{1,2},\\d{1,2}\\)$");
    }

    public List<Point> parsePoints(String input) {
        String[] pointStrings = input.split("-");
        ArrayList<Point> points = new ArrayList<>();
        for (String pointString : pointStrings) {
            pointString = pointString.replaceAll("[()]", "").trim();
            String[] coordinates = pointString.split(",");
            Point point = Point.create(
                    Integer.parseInt(coordinates[0].trim()),
                    Integer.parseInt(coordinates[1].trim())
            );
            points.add(point);
        }
        return points;
    }
}
