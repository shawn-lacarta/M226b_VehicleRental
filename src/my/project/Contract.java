package my.project;

import java.time.LocalDate;

public class Contract {
    private LocalDate startDate;
    private LocalDate endDate;
    private String condition;
    private Customer customer;
    private Vehicle vehicle;

    public Contract(LocalDate startDate, LocalDate endDate, String condition, Customer customer, Vehicle vehicle) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.condition = condition;
        this.customer = customer;
        this.vehicle = vehicle;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
