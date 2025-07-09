package fuel2;

public class Sonata extends Car implements ReportableCar {

    private static final String NAME = "Sonata";
    private static final int KM_PER_LITER = 10; // Example value, adjust as needed

    public Sonata(int distance) {
        super(NAME, distance);
    }

    @Override
    public int calculateFuelConsumption() {
        return getDistance() / KM_PER_LITER;
    }
}
