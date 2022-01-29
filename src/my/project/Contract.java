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

    public LocalDate getEndDate() {
        return this.endDate;
    }

}
