package fuel;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private final List<Car> cars;

    private RentCompany() {
        this.cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        if (car != null) {
            cars.add(car);
        }
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        for (Car car : cars) {
            int fuelConsumption = car.calculateFuelConsumption();
            String carName = car.getName();
            report.append(carName).append(" : ").append(fuelConsumption).append("리터").append(System.lineSeparator());
        }
        return report.toString();
    }
}
