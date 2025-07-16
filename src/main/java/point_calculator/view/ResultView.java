package point_calculator.view;

import point_calculator.calculator.Calculator;
import point_calculator.domain.Plane;

public class ResultView {
    public void printResult(Plane plane, Calculator calculate) {
        plane.print();
        System.out.println();
        calculate.print();
    }
}
