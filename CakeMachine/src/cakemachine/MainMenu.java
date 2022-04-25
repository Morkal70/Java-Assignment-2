/**Author: Matthew Toon - M1001886*/
package cakemachine;
import java.util.Scanner;

public class MainMenu {
    private static int menuOption = -1;
    private static String username;
    private static Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }
    private static void mainMenu() {
        if (username == null) {
            getName();
        }
        System.out.println("Welcome to Mclovin's Muffins!\n");
        while (menuOption != 0) {
            System.out.println("Select an option\n"
                    + "1. Add recipe \n"
                    + "2. Delete recipe\n"
                    + "3. Add order\n"
                    + "4. Delete order\n"
                    + "5. View old (completed)? orders\n"
                    + "6. Orders due\n"
                    + "7. Current ingredients required\n"
                    + "0. Exit");

            menuOption = SC.nextInt();

            if (menuOption == 1) {
                SC.nextLine();
                getName();
                //break;
            } else if (menuOption == 2) {
                //poolShape = "Rectangular";
                //rectangleInternalSurfaceArea();
                //rectangleVolume();
                break;
            } else if (menuOption == 3) {
                //poolShape = "Circular";
                //circleInternalSurfaceArea();
                //circleVolume();
                break;
            } else if (menuOption == 4) {
                break;
            } else if (menuOption == 5) {
                break;
            } else if (menuOption == 6) {
                break;
            } else if (menuOption == 7) {
                break;
            } else if (menuOption == 0) {
                System.exit(0);
            } else {
                System.out.println("Please select an option from 1 through 7 to proceed, or 0 to exit");
            }// end of IF statement
        }//end of while loop

    }//mainMenu

    private static void getName() {
        System.out.println("Please enter your name");
        username = SC.nextLine();
        System.out.println("Your username: " + username);
        //add validation later to check correct input
    }
}
