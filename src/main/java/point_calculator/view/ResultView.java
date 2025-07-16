package point_calculator.view;

import point_calculator.domain.Plane;

public class ResultView {
    public void printResult(Plane plane, double calculate) {
        plane.print();
        System.out.println("\n두 점 사이 거리는 : " + calculate);
    }
}
