package my.project;

public class Scooter extends TwoSeat {
    private String batteryPower;

    public Scooter(String color, double kmh, String carName, String fuel, int seat, double price, boolean helmetStand, String batteryPower, License license) {
        super(color, kmh, carName, fuel, seat, price, helmetStand, license);
        this.batteryPower = batteryPower;
    }
}
