package main;

import controller.CoordinateCalculator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CoordinateCalculator coordinateCalculator = new CoordinateCalculator(inputView, outputView);
        coordinateCalculator.run();
    }
}
