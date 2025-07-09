package fuel2;

public class  K5 extends Car implements ReportableCar {

    private static final String NAME = "K5";
    private static final int KM_PER_LITER = 13; // Example value, adjust as needed

    public K5(int distance) {
        super(NAME, distance);
    }

    @Override
    public int calculateFuelConsumption() {
        return getDistance() / KM_PER_LITER;
    }
}
