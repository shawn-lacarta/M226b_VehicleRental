package my.project;

public class Car extends Vehicle {
    private String tireType;

    public Car(String color, double kmh, String carName, String fuel, int seat, double price, String tireType, License license) {
        super(color, kmh, carName, fuel, seat, price, license);
        this.tireType = tireType;
    }

    public String getTireType() {
        return this.tireType;
    }

    public void setTireType(String tireType) {
        this.tireType = tireType;
    }
}
