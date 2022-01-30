package my.project.test;

import my.project.Contract;
import my.project.Manager;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;


class ManagerTest {

private Manager manager = new Manager();

    @org.junit.jupiter.api.Test
    void printContracts() throws Exception{
         Contract contract = new Contract(LocalDate.of(2021, 12, 12), LocalDate.of(2021, 12, 13), null, null, null);
        Assertions.assertTrue(contract.getStartDate().equals(LocalDate.of(2021, 12,12)));
    }

    @org.junit.jupiter.api.Test
    void printVehicles() throws Exception{
        manager.addVehicles();
        Assertions.assertTrue(manager.getVehicles().get(1).getCarName().equals("honda civic"));
    }

    @org.junit.jupiter.api.Test
    void printPersons() throws Exception{
        manager.addCustomer();
        Assertions.assertTrue(manager.getCustomers().get(0).getName().equals("mikal"));
    }
}