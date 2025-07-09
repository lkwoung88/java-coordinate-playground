package fuel2;

public class Car {

    private final String name;
    private final int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
