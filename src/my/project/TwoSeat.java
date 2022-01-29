package my.project;

/**
 * This class is responsible for all the TwoSeat in this
 * project. It is extending from Vehicle because Vehicle
 * has the basic to build a TwoSeat.
 */
public class TwoSeat extends Vehicle {
    protected boolean helmetStand;

    public TwoSeat(String color, double kmh, String carName, String fuel, int seat, double price, boolean helmetStand, License license) {
        super(color, kmh, carName, fuel, seat, price, license);
        this.helmetStand = helmetStand;
    }
}
