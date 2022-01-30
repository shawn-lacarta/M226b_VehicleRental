package my.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class is responsible for In and Output. Here you can
 * find all methods that have something to do directly with
 * the user.
 */
public class IO {

    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";
    private final String PASSWORD = "test";
    private Scanner scan = new Scanner(System.in);
    private Manager m = new Manager();

    /**
     * This method is responsible for the BorderBox. This is
     * to make the output look better for the user.
     *
     * @param strings Give strings for output
     * @param mode    Give mode for the output
     */
    public static void outPutListInBox(String[] strings, int mode) {
        int borderLength = 0;

        int i;
        for (i = 0; i < strings.length; ++i) {
            if (i == 0 || strings[i].length() + 3 > borderLength) {
                borderLength = strings[i].length() + 3;
            }
        }

        System.out.print("╔");
        line(borderLength + 1);
        System.out.println("╗");

        for (i = 0; i < strings.length; ++i) {
            System.out.print("║");
            switch (mode) {
                case 1:
                    System.out.print(" " + (i + 1) + ". " + strings[i]);
                    break;
                case 2:
                    System.out.print(" " + strings[i]);
                    break;
                case 3:
                    System.out.print(" •  " + strings[i]);
            }

            for (int j = 0; j < borderLength - strings[i].length(); ++j) {
                System.out.print(" ");
            }

            System.out.print("║");
            System.out.println();
        }

        System.out.print("╚");
        line(borderLength + 1);
        System.out.println("╝");
    }

    /**
     * This method belongs for the BorderBox. It separates the
     * individual boxes by lines.
     *
     * @param length Length of the line
     */
    private static void line(int length) {
        for (int i = 0; i < length; ++i) {
            System.out.print("═");
        }

    }

    /**
     * This method is responsible that the user gets a nice welcome.
     */
    public void greeting() {
        System.out.println(ANSI_CYAN + readFile("../files/welcome.txt") + ANSI_RESET);
        m.addVehicles();
        m.addCustomer();
    }

    /**
     * This method represents the start menu for the user. Here the
     * user can choose in which direction he wants to move in the application.
     */
    public void startMenu() {
        while (true) {
            while (true) {
                IO.outPutListInBox(new String[]{"1. list vehicle", "2. rent vehicle", "3. log in as admin"}, 2);
                int input = readRangedInt(1, 4);
                switch (input) {
                    case 1 -> printVehicle();
                    case 2 -> m.makeContract();
                    case 3 -> adminMenu();
                    default -> System.out.println("something went wrong");
                }
            }
        }
    }

    /**
     * This method represents the start menu for the admin. The admin
     * has additional features.
     */
    public void adminMenu() {
        System.out.println("password: ");
        String password = scan.nextLine();

        while (true) {
            if (password.equals(PASSWORD)) {
                IO.outPutListInBox(new String[]{"1. list clients", "2. list contracts", "3. log out as admin"}, 2);
                int input = readRangedInt(1, 3);
                switch (input) {
                    case 1 -> printCustomer();
                    case 2 -> m.printContracts();
                    case 3 -> startMenu();
                    default -> System.out.println("something went wrong");
                }
            } else {
                System.out.println("wrong password");
                startMenu();
            }
        }
    }

    /**
     * This method prints all vehicles by price, number of seats, fuel,
     * color and max speed.
     */
    public void printVehicle() {

        String[] data = new String[6];
        Iterator var2 = m.getVehicles().iterator();

        while (var2.hasNext()) {
            Vehicle v = (Vehicle) var2.next();
            data[0] = v.carName;
            data[1] = "price: " + String.valueOf(v.price);
            data[2] = "seat: " + String.valueOf(v.seat);
            data[3] = "fuel: " + v.fuel;
            data[4] = "color: " + v.color;
            data[5] = "max speed: " + String.valueOf(v.kmh) + " km/h";
            IO.outPutListInBox(data, 2);
        }

    }

    /**
     * This method prints all customers that are registered.
     */
    public void printCustomer() {

        String[] data = new String[4];
        Iterator var2 = m.getCustomers().iterator();
        while (var2.hasNext()) {
            Customer c = (Customer) var2.next();
            data[0] = c.getName();
            data[1] = c.getLastname();
            data[2] = String.valueOf(c.getAge());
            data[3] = c.getGender();
            IO.outPutListInBox(data, 2);
        }
    }


    /**
     * This method is responsible for the validation of Integers. If the
     * user input is not an Integer it will be parsed to an int.
     *
     * @return It will return input. Input is the parsed value.
     */
    public static int readInt() {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                input = Integer.parseInt(scan.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("wrong input");
            }
        }
        return input;
    }

    /**
     * This method is responsible for the validation of the min and
     * max value of the user inputs. In this method i can define the range
     * of the user inputs.
     *
     * @param min This parameter is responsible for the min value.
     * @param max This parameter is responsible for the max value.
     * @return This method returns the readInt method.
     */
    public static int readRangedInt(int min, int max) {
        int input = readInt();
        while (input < min || input > max) {
            System.out.println("wrong input");
            input = readInt();
        }
       
        return input;
    }

    /**
     * This method is responsible to read files.
     * @param filename the filename, that this method should look at
     * @return returns the content of the file
     */
    public String readFile(String filename){
        try {
            StringBuilder fileContent = new StringBuilder();
            Scanner fileReader = new Scanner(new File("maps/" + filename));
            while (fileReader.hasNextLine()) {
                fileContent.append(fileReader.nextLine()).append("\n");
            }
            return fileContent.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
}
