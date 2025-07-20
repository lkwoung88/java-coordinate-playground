package view;

import model.Coordinate;
import model.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String DISPLAY_INPUT_MESSAGE = "좌표를 입력하세요.\n";
    public static final String COORDINATION_FORMAT_ERROR_MESSAGE = "좌표 입력 형식이 올바르지 않습니다. 예시: (1,2)-(3,4)-(5,6)";

    public static final String COORDINATE_INPUT_FORMAT = "(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){1,3}";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Coordinates getCoordinates() {
        System.out.println(DISPLAY_INPUT_MESSAGE);
        String input = scanner.nextLine().replace(" ", "");
        return extractCoordinateListBy(input);
    }

    public Coordinates extractCoordinateListBy(String input) {
        if (isNotValidInputFormat(input)) {
            throw new IllegalArgumentException(COORDINATION_FORMAT_ERROR_MESSAGE);
        }

        String[] coordinatePairs = input.split("-");
        List<Coordinate> coordinates = extractCoordinateListBy(coordinatePairs);
        return new Coordinates(coordinates);
    }

    private List<Coordinate> extractCoordinateListBy(String[] coordinatePairs) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        for (String pair : coordinatePairs) {
            String[] coordinate = pair.replaceAll("[()]", "").split(",");
            coordinates.add(new Coordinate(Integer.parseInt(coordinate[0]), Integer.parseInt(coordinate[1])));
        }
        return coordinates;
    }

    private boolean isNotValidInputFormat(String input) {
        return !isValidInputFormat(input);
    }

    private boolean isValidInputFormat(String input) {
        return input.matches(COORDINATE_INPUT_FORMAT);
    }
}
