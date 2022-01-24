package my.project;

import java.util.Scanner;

public class IO {

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void outPutListInBox(String[] strings, int mode) {
        int borderLength = 0;

        int i;
        for(i = 0; i < strings.length; ++i) {
            if (i == 0 || strings[i].length() + 3 > borderLength) {
                borderLength = strings[i].length() + 3;
            }
        }

        System.out.print("╔");
        line(borderLength + 1);
        System.out.println("╗");

        for(i = 0; i < strings.length; ++i) {
            System.out.print("║");
            switch(mode) {
                case 1:
                    System.out.print(" " + (i + 1) + ". " + strings[i]);
                    break;
                case 2:
                    System.out.print(" " + strings[i]);
                    break;
                case 3:
                    System.out.print(" •  " + strings[i]);
            }

            for(int j = 0; j < borderLength - strings[i].length(); ++j) {
                System.out.print(" ");
            }

            System.out.print("║");
            System.out.println();
        }

        System.out.print("╚");
        line(borderLength + 1);
        System.out.println("╝");
    }

    private static void line(int length) {
        for(int i = 0; i < length; ++i) {
            System.out.print("═");
        }

    }

    public void greeting(){

        System.out.println(ANSI_CYAN + " __   __  _______  __   __  ___   _______  ___      _______    ______    _______  __    _  _______  _______  ___     \n" +
                "|  | |  ||       ||  | |  ||   | |       ||   |    |       |  |    _ |  |       ||  |  | ||       ||   _   ||   |    \n" +
                "|  |_|  ||    ___||  |_|  ||   | |       ||   |    |    ___|  |   | ||  |    ___||   |_| ||_     _||  |_|  ||   |    \n" +
                "|       ||   |___ |       ||   | |       ||   |    |   |___   |   |_||_ |   |___ |       |  |   |  |       ||   |    \n" +
                "|       ||    ___||       ||   | |      _||   |___ |    ___|  |    __  ||    ___||  _    |  |   |  |       ||   |___ \n" +
                " |     | |   |___ |   _   ||   | |     |_ |       ||   |___   |   |  | ||   |___ | | |   |  |   |  |   _   ||       |\n" +
                "  |___|  |_______||__| |__||___| |_______||_______||_______|  |___|  |_||_______||_|  |__|  |___|  |__| |__||_______|" + ANSI_RESET);
    }

    public void startMenu(){
        Manager output = new Manager();
        Scanner scan = new Scanner(System.in);

        greeting();
        while(true) {
            while(true) {
                IO.outPutListInBox(new String[]{"1. list vehicle", "2. list clients", "3. rent vehicle", "4. list contracts"}, 2);
                int input = readRangedInt(1, 4);
                switch(input) {
                    case 1:
                        output.printVehicle();
                        break;
                    case 2:
                        output.printCustomer();
                        break;
                    case 3:
                        output.makeContract();
                        break;
                    case 4:
                        output.printContracts();
                        break;
                    default:
                        System.out.println("Something went wrong");
                }
            }
        }
    }

    /**
     * This method is responsible for the validation of Integers. If the
     * user input is not an Integer it will be parsed to an int.
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

}
