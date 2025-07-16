package point_calculator.main;

import point_calculator.calculator.LineCalculator;
import point_calculator.domain.Plane;
import point_calculator.domain.Point;
import point_calculator.view.InputView;
import point_calculator.view.ResultView;

import java.util.List;

public class PointApplication {

    private final InputView inputView;
    private final ResultView resultView;

    public PointApplication(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void switchOn() {
        Plane plane = Plane.create();
        List<Point> points = inputView.requestPoints();
        plane.markPoints(points);
        LineCalculator lineCalculator = new LineCalculator();
        resultView.printResult(plane, lineCalculator.calculate(points));
    }
}
