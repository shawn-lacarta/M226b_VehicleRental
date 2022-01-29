package my.project;

/**
 * This class is responsible for cars. It is extended with
 * Vehicle, because Vehicle has the basic base to make a car.
 */
public class Car extends Vehicle {
    private String tireType;

    public Car(String color, double kmh, String carName, String fuel, int seat, double price, String tireType, License license) {
        super(color, kmh, carName, fuel, seat, price, license);
        this.tireType = tireType;
    }

}
