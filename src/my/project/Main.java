package my.project;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Manager output = new Manager();
        Scanner scan = new Scanner(System.in);

        while(true) {
            while(true) {
                IO.outPutListInBox(new String[]{"Welcome to my shop", "1. list vehicle", "2. list clients", "3. rent vehicle", "4. list contracts"}, 2);
                System.out.println("What do you want to do?");
                int input = scan.nextInt();
                switch(input) {
                    case 1:
                        output.addVehicles();
                        break;
                    case 2:
                        output.addCustomer();
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
}
