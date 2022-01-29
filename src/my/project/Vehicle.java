package my.project;

/**
 * This class is responsible for every vehicle in this
 * project. It has every attribute to build a vehicle.
 */
public class Vehicle {
    protected String color;
    protected double kmh;
    protected String carName;
    protected String fuel;
    protected int seat;
    protected double price;
    protected License license;

    public Vehicle(String color, double kmh, String carName, String fuel, int seat, double price, License license) {
        this.color = color;
        this.kmh = kmh;
        this.carName = carName;
        this.fuel = fuel;
        this.seat = seat;
        this.price = price;
        this.license = license;
    }


    public String getCarName() {
        return this.carName;
    }

    public License getLizens() {
        return this.license;
    }

}
