
import java.util.Scanner;

public class InputHelper {
//

    public static String getNonZeroLenString(Scanner scan, String prompt) {
        String s = "";
        boolean done = false;

        System.out.println(prompt);

        do {
            s = scan.nextLine();
            if (s.length() > 0) {
                done = true;
            } else {
                System.out.println("Invalid length");
            }
        } while (!done);
        return(s);
    }
    /*
     * Loops through until the user enters a valid int value
     * Displays error message and asks user to try again until valid input received
     * */
    public static int getInt(Scanner scan, String prompt){
        int num = 0; //the value that is eventually returned to the user
        boolean done = false;

        System.out.println(prompt);
        do {
            if(scan.hasNextInt()) {
                num = scan.nextInt();
                done = true;
            }
            else {
                System.out.println("Invalid Input. Please try again.");
            }
            scan.nextLine();
        } while (!done);
        return num;
    }

    /*
     * Loops through until the user enters a valid int value
     * Displays error message and asks user to try again until valid input received
     * */
    public static int getPositiveNonZeroInt(Scanner scan, String prompt){
        int num = 0; //the value that is eventually returned to the user
        boolean done = false;

        System.out.println(prompt);
        do {
            if(scan.hasNextInt()) {
                num = scan.nextInt();
                if (num > 0) {
                    done = true;
                }
                else {
                    System.out.println("Please enter a positive, non-zero integer value.");
                }
            }
            else {
                System.out.println("Invalid Input. Please try again.");
            }
            scan.nextLine();
        } while (!done);
        return num;
    }

    /*
     * Loops through until the user enters a valid int value
     * Displays error message and asks user to try again until valid input received
     * If you input an integer outside the range, it will loop
     * */
    public static int getRangedInt(Scanner scan, String prompt, int min, int max){
        int num = 0; //the value that is eventually returned to the user
        boolean done = false;

        System.out.println(prompt);
        do {
            if(scan.hasNextInt()) {
                num = scan.nextInt();
                if (num >= min && num <= max) {
                    done = true;
                }
                else {
                    System.out.println("Try again, enter a number between " + min + " and " + max);
                }
            }
            else {
                System.out.println("Invalid Input. Please try again.");
            }
            scan.nextLine();
        } while (!done);
        return num;
    }

    public static double getDouble(Scanner scan, String prompt){
        double num = 0; //the value that is eventually returned to the user
        boolean done = false;

        System.out.println(prompt);
        do {
            if(scan.hasNextDouble()) {
                num = scan.nextDouble();
                done = true;
            }
            else {
                System.out.println("Invalid Input. Please try again.");
            }
            scan.nextLine();
        } while (!done);
        return num;
    }

    public static double getRangedDouble(Scanner scan, String prompt, double min, double max){
        double num = 0; //the value that is eventually returned to the user
        boolean done = false;

        System.out.println(prompt);
        do {
            if(scan.hasNextDouble()) {
                num = scan.nextDouble();
                if (num >= min && num <= max) {
                    done = true;
                }
                else {
                    System.out.println("Try again, enter a number between " + min + " and " + max);
                }

            }
            else {
                System.out.println("Invalid Input. Please try again.");
            }
            scan.nextLine();
        } while (!done);
        return num;
    }

    public static boolean getYNConfirm(Scanner scan, String prompt) {
        String input;
        boolean yes = false;
        boolean done = false;

        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if (input.equalsIgnoreCase("y")) {
                yes = true;
                done = true;
            }
            else if (input.equalsIgnoreCase("n")) {
                yes = false;
                done = true;
            }
            else {
                done = false;
                System.out.println("Invalid Input");
            }
        } while(!done);
        return yes;
    }

    public static String getRegExString(Scanner scan, String prompt, String regEXPattern) {
        String input;
        boolean done = false;

        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if (input.matches(regEXPattern)) {
                done = true;
            }
            else {
                System.out.println("invalid pattern");
            }
        } while(!done);
        return input;
    }

    public static void prettyHeader (String msg) {
        for(int i = 0; i <= 60; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("***");
        for(int i = 0; i <= 26 - msg.length()/2; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for(int i = 0; i <= 26 - (msg.length()/2); i++) {
            System.out.print(" ");
        }
        System.out.print("***");
        System.out.println();
        for(int i = 0; i <= 60; i++) {
            System.out.print("*");
        }
    }


}
