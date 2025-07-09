package fuel2;

public class Avante extends Car implements ReportableCar {

    private static final String NAME = "Avante";
    private static final int KM_PER_LITER = 15; // Example value, adjust as needed

    public Avante(int distance) {
        super(NAME, distance);
    }

    @Override
    public int calculateFuelConsumption() {
        return getDistance() / KM_PER_LITER;
    }
}
