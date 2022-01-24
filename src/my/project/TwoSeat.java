package my.project;

public class TwoSeat extends Vehicle {
    protected boolean helmetStand;

    public TwoSeat(String color, double kmh, String carName, String fuel, int seat, double price, boolean helmetStand, Lizens lizens) {
        super(color, kmh, carName, fuel, seat, price, lizens);
        this.helmetStand = helmetStand;
    }
}
