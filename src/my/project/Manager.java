package my.project;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is responsible for the logic during the whole
 * program.
 */
public class Manager {

    private ArrayList<Vehicle> vehicles = new ArrayList();
    private ArrayList<Contract> contracts = new ArrayList();
    private ArrayList<Customer> customers = new ArrayList();
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private Scanner scan = new Scanner(System.in);

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    /**
     * This method creates all the vehicles that are for rent. Here
     * we have cars, motorcycles and scooters.
     */
    public void addVehicles() {
        vehicles.add(new Car("black", 314.0D, "dodge charger hellcat", "petrol", 5, 120000.0D, "summer", License.car));
        vehicles.add(new Car("red", 272.0D, "honda civic", "petrol", 5, 50000.0D, "summer", License.car));
        vehicles.add(new Car("white", 261.0D, "tesla model x", "electronic", 5, 190000.0D, "winter", License.car));
        vehicles.add(new MotorCycle("green", 210.0D, "suzuki", "petrol", 2, 60000.0D, false, License.motor));
        vehicles.add(new MotorCycle("yellow", 231.0D, "yamaha", "petrol", 2, 90000.0D, true, License.motor));
        vehicles.add(new Scooter("black", 120.0D, "vespa", "electronic", 2, 3900.0D, true, "20aH", License.scooter));

    }

    /**
     * This method creates all customers registered in the company. To
     * make the whole thing varied, each customer has different licenses
     * or ages.
     */
    public void addCustomer() {
        customers.add(new Customer("mikal", "longer", 18, "male", License.car));
        customers.add(new Customer("stephen", "marry", 16, "male", License.car));
        this.customers.add(new Customer("Max", "Muster", 14, "male", License.motor));
    }

    /**
     *A contract is created here. First, you can select a car. After
     * that you choose who you are. At last you can define the start and end
     * date. Of course, the whole thing is also checked whether you have the
     * right to do so.
     */
    public void makeContract() {
        int[] formatteddateintstart = new int[3];
        int[] formatteddateintend = new int[3];
        this.printVehicles();
        int vehicleIndex = this.scan.nextInt() - 1;
        printPersons();
        int personIndex = this.scan.nextInt() - 1;
        if (((Customer)this.customers.get(personIndex)).getAge() > 17 && ((Vehicle)this.vehicles.get(vehicleIndex)).getLizens() == ((Customer)this.customers.get(personIndex)).getLicense()) {
            String comment;
            int j;
            label37:
            while(true) {
                try {
                    System.out.println("Start (YYYY, MM, DD): ");
                    scan.nextLine();
                    comment = this.scan.nextLine();
                    String[] formatteddatestart = comment.split(", ");
                    j = 0;

                    while(true) {
                        if (j >= formatteddatestart.length) {
                            break label37;
                        }

                        formatteddateintstart[j] = Integer.parseInt(formatteddatestart[j]);
                        ++j;
                    }
                } catch (Exception var10) {
                    System.out.println("Invalid date");
                }
            }

            label28:
            while(true) {
                try {
                    System.out.println("End (YYYY, MM, DD): ");
                    comment = this.scan.nextLine();
                    String[] formatteddateend = comment.split(", ");
                    j = 0;

                    while(true) {
                        if (j >= formatteddateend.length) {
                            break label28;
                        }

                        formatteddateintend[j] = Integer.parseInt(formatteddateend[j]);
                        ++j;
                    }
                } catch (Exception var9) {
                    System.out.println("Invalid date");
                }
            }

            System.out.println("Comment:");
            comment = this.scan.nextLine();
            Contract contract = new Contract(LocalDate.of(formatteddateintstart[0], formatteddateintstart[1], formatteddateintstart[2]), LocalDate.of(formatteddateintend[0], formatteddateintend[1], formatteddateintend[2]), comment, (Customer)this.customers.get(personIndex), (Vehicle)this.vehicles.get(vehicleIndex));
            this.contracts.add(contract);
        }else{
            System.out.println(ANSI_RED + "wrong license or under age" + ANSI_RESET);
        }

    }

    /**
     * Here are printed the vehicles that you can select. This
     * is part of the makeContract process.
     */
    public void printContracts() {
        for (int i = 0; i < contracts.size(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = ((Customer) customers.get(i)).getName();
            var10000.println("Name: " + var10001 + "\nAge: " + ((Customer) customers.get(i)).getAge() + "\nVehicle: " + ((Vehicle) vehicles.get(i)).getCarName() + "\nStart date: " + ((Contract) contracts.get(i)).getStartDate() + "\nEnd date: " + ((Contract) contracts.get(i)).getEndDate());
            System.out.println();
        }

    }

    /**
     * Here are printed the vehicles that you can select. This
     * is part of the makeContract process.
     */
    public void printVehicles() {
        System.out.println("vehicles:");
        for (int i = 0; i < vehicles.size(); ++i) {
            System.out.println(((Vehicle) vehicles.get(i)).getCarName());
        }

        System.out.println(ANSI_PURPLE + "enter a vehicle (1-6): " + ANSI_RESET);
    }

    /**
     * Here are printed the persons that you can select. This
     * is part of the makeContract process.
     */
    public void printPersons() {
        System.out.println("person:");
        for (int i = 0; i < customers.size(); ++i) {
            System.out.println(((Customer) customers.get(i)).getName());
        }
        System.out.println(ANSI_PURPLE + "enter person (1-3): " + ANSI_RESET);
    }
}