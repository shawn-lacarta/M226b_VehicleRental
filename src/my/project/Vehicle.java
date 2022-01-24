package my.project;

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

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getKmh() {
        return this.kmh;
    }

    public void setKmh(double kmh) {
        this.kmh = kmh;
    }

    public String getCarName() {
        return this.carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getFuel() {
        return this.fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getSeat() {
        return this.seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public License getLizens() {
        return this.license;
    }

    public void setLicens(License license) {
        this.license = license;
    }
}
