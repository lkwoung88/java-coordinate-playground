package point_calculator;

import point_calculator.main.PointApplication;
import point_calculator.view.InputView;
import point_calculator.view.ResultView;

public class Application {

    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        InputView inputView = new InputView();
        PointApplication pointApplication = new PointApplication(inputView, resultView);
        pointApplication.switchOn();
    }
}
