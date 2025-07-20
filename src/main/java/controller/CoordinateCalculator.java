package controller;

import model.Coordinates;
import model.Figure;
import model.FigureFactory;
import view.InputView;
import view.OutputView;

public class CoordinateCalculator {

    private final InputView inputView;
    private final OutputView outputView;

    public CoordinateCalculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Coordinates coordinates = inputView.getCoordinates();
        Figure figure = FigureFactory.createFigures(coordinates);
        outputView.showCoordinatePlane(figure);
        outputView.showArea(figure);
    }
}
