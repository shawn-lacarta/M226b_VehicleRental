package my.project;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Manager {
    private ArrayList<Vehicle> vehicles = new ArrayList();
    private ArrayList<Contract> contracts = new ArrayList();
    private ArrayList<Customer> customers = new ArrayList();
    Scanner scan;

    public Manager() {
        this.scan = new Scanner(System.in);
    }

    public void addVehicles() {
        this.vehicles.add(new Car("black", 314.0D, "dodge charger hellcat", "petrol", 5, 120000.0D, "summer", License.car));
        this.vehicles.add(new Car("red", 272.0D, "honda civic", "petrol", 5, 50000.0D, "summer", License.car));
        this.vehicles.add(new Car("white", 261.0D, "tesla model x", "electronic", 5, 190000.0D, "winter", License.car));
        this.vehicles.add(new MotorCycle("green", 210.0D, "suzuki", "petrol", 2, 60000.0D, false, License.motor));
        this.vehicles.add(new MotorCycle("yellow", 231.0D, "yamaha", "petrol", 2, 90000.0D, true, License.motor));
        this.vehicles.add(new Scooter("black", 120.0D, "vespa", "electronic", 2, 3900.0D, true, "20aH", License.scooter));

    }

    public void printVehicle(){
        addVehicles();
        String[] data = new String[6];
        Iterator var2 = this.vehicles.iterator();

        while(var2.hasNext()) {
            Vehicle v = (Vehicle)var2.next();
            data[0] = v.carName;
            data[1] = "price: " + String.valueOf(v.price);
            data[2] = "seat: " + String.valueOf(v.seat);
            data[3] = "fuel: " + v.fuel;
            data[4] = "color:" + v.color;
            data[5] = "max speed: " + String.valueOf(v.kmh) + " km/h";
            IO.outPutListInBox(data, 2);
        }

    }

    public void printContracts() {
        for(int i = 0; i < this.contracts.size(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = ((Customer)this.customers.get(i)).getName();
            var10000.println("Name: " + var10001 + "\nAge: " + ((Customer)this.customers.get(i)).getAge() + "\nVehicle: " + ((Vehicle)this.vehicles.get(i)).getCarName() + "\nStart date: " + ((Contract)this.contracts.get(i)).getStartDate() + "\nEnd date: " + ((Contract)this.contracts.get(i)).getEndDate());
            System.out.println();
        }

    }

    public void addCustomer() {
        this.customers.add(new Customer("Shawn", "Lacarta", 18, "male", License.car));
        this.customers.add(new Customer("Anojan", "Pirabakaran", 16, "male", License.car));
        this.customers.add(new Customer("Max", "Muster", 14, "male", License.motor));

    }
    public void printCustomer(){
        addCustomer();
        String[] data = new String[4];
        Iterator var2 = this.customers.iterator();
        while(var2.hasNext()) {
            Customer c = (Customer)var2.next();
            data[0] = c.getName();
            data[1] = c.getLastname();
            data[2] = String.valueOf(c.getAge());
            data[3] = c.getGender();
            IO.outPutListInBox(data, 2);
        }
    }

    public void printVehicles() {
        System.out.println("Vehicles:");

        for(int i = 0; i < this.vehicles.size(); ++i) {
            System.out.println(((Vehicle)this.vehicles.get(i)).getCarName());
        }

        System.out.println("Enter a Vehicle (1-6): ");
        System.out.println();
    }

    public void makeContract() {
        int[] formatteddateintstart = new int[3];
        int[] formatteddateintend = new int[3];
        this.printVehicles();
        int vehicleIndex = this.scan.nextInt() - 1;
        printPersons();
        int personIndex = this.scan.nextInt() - 1;
        if (((Customer)this.customers.get(personIndex)).getAge() > 17 && ((Vehicle)this.vehicles.get(vehicleIndex)).getLizens() == ((Customer)this.customers.get(personIndex)).getLizens()) {
            String comment;
            int j;
            label37:
            while(true) {
                try {
                    System.out.println("Start (YYYY, MM, DD): ");
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
        }

    }

    public void printPersons() {
        System.out.println("Person:");

        for(int i = 0; i < customers.size(); ++i) {
            System.out.println(((Customer)customers.get(i)).getName());
        }

        System.out.println("Enter Person (1-3): ");

    }
}