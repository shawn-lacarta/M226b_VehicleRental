package my.project;

/**
 * This class is responsible for motorcycles. It is extended
 * with TwoSeat because TwoSeat has the basic to build a
 * motorcycle.
 */
public class MotorCycle extends TwoSeat {
    public MotorCycle(String color, double kmh, String carName, String fuel, int seat, double price, boolean helmetStand, License license) {
        super(color, kmh, carName, fuel, seat, price, helmetStand, license);
    }
}