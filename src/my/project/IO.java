package my.project;

import java.util.Scanner;

public class IO {

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

    public void startMenu(){
        Manager output = new Manager();
        Scanner scan = new Scanner(System.in);

        while(true) {
            while(true) {
                IO.outPutListInBox(new String[]{"Welcome to my shop", "1. list vehicle", "2. list clients", "3. rent vehicle", "4. list contracts"}, 2);
                System.out.println("What do you want to do?");
                int input = scan.nextInt();
                switch(input) {
                    case 1:
                        output.printVehicle();
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
