/**Author: Matthew Toon - M1001886*/
package cakemachine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class CakeMachine {
    private static int menuOption = -1;
    private static String username, cakeName, ingredients, instructions, cakeToDelete, orderToDelete;
    private static ArrayList<String> recipeList = new ArrayList<String>();
    private static ArrayList<String> orderList = new ArrayList<String>();
    private static ArrayList<String> oldOrders = new ArrayList<String>();
    private static ArrayList<String> ordersDue = new ArrayList<String>();
    private static Scanner SC = new Scanner(System.in);
    private static Scanner recipeSC = new Scanner(System.in);
    private static Scanner deleteSC = new Scanner(System.in);
    private static Scanner orderSC = new Scanner(System.in);
    private static Scanner deleteOrderSC = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }
    private static void mainMenu() {
        if (username == null) {
            getName();
        }
        System.out.println("Welcome to Mclovin's Muffins, " + username + "!");
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
                addRecipe();
            } else if (menuOption == 2) {
               deleteRecipe();
            } else if (menuOption == 3) {
                addOrder();
            } else if (menuOption == 4) {
                deleteOrder();
            } else if (menuOption == 5) {
                //oldOrders();
            } else if (menuOption == 6) {
                //dueOrders();
            } else if (menuOption == 7) {
                totalIngredients();
            } else if (menuOption == 0) {
                System.exit(0);
            } else {
                System.out.println("Please select an option from 1 through 7 to proceed, or 0 to exit");
            }// end of IF statement
        }//end of while loop

    }//mainMenu

    private static void getName() {
        System.out.println("Please enter your name.");
        username = SC.nextLine();
        System.out.println("Your username: " + username);
        //add validation later to check correct input
    }

    private static void addRecipe(){
        System.out.println("Please enter the name of the cake.");
        recipeList.add(recipeSC.nextLine());
        System.out.println("Please enter the ingredients.");
        recipeList.add(recipeSC.nextLine());
        System.out.println("Please enter the instructions.");
        recipeList.add(recipeSC.nextLine());
        System.out.println(recipeList);
    }


    private static void deleteRecipe() {
        System.out.println("Please enter the name of the cake to delete.");
        cakeToDelete = deleteSC.nextLine();
        for (int i = 0; i < recipeList.size(); i++) {
            if (recipeList.get(i).contains(cakeToDelete)) {
                recipeList.remove(i);
                recipeList.remove(i);
                recipeList.remove(i);
            }
        } System.out.println(recipeList);
    }
    private static void addOrder(){
        System.out.println("Please enter the client's name.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the client's contact details.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the delivery address.");
        orderList.add(orderSC.nextLine());
        LocalDate orderDate = LocalDate.now();
        orderList.add(String.valueOf(orderDate)); //automatically adds today's date as string to list
        LocalDate deliveryDate = orderDate.plusDays(3);
        orderList.add(String.valueOf(deliveryDate));
        System.out.println("Please enter the type of cake.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the cake size.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the cake shape.");
        orderList.add(orderSC.nextLine());
        System.out.println(orderList);

    }
    private static void deleteOrder(){
        System.out.println("Please enter the name of the client to delete their order.");
        orderToDelete = deleteOrderSC.nextLine();
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).contains(orderToDelete)) {
                orderList.remove(i);
                orderList.remove(i);
                orderList.remove(i);
                orderList.remove(i);
                orderList.remove(i);
                orderList.remove(i);
                orderList.remove(i);
                orderList.remove(i);
            }
        } System.out.println(orderList);
    }
    //https://stackoverflow.com/questions/33968333/how-to-check-if-a-string-is-date
    //https://www.tutorialspoint.com/how-to-compare-two-dates-in-java
    private static void oldOrders(){
        String deliveryDate = orderList.get(4); //stores index 4 inside new string
        LocalDate date = LocalDate.parse(deliveryDate); // converts delivery date string to actual date
        LocalDate today = LocalDate.now();
        if (deliveryDate.compareTo(today) > 0) {
            System.out.println("delivery date occurs AFTER today's date");
        } else if (deliveryDate.compareTo(today) < 0) {
            System.out.println("delivery date occurs BEFORE today's date"); //move elements 0-7 to new list, print list
        } else if (deliveryDate.compareTo(today) == 0) {
            System.out.println("delivery date is today");
        }
        //repeat process if index 4 is still populated
        //finish by printing list
    }
    private static void dueOrders(){
        //same idea as oldOrders, but check if delivery date is AFTER today, or today - move entire order to new list, print list
    }
    private static void totalIngredients(){
        System.out.println("The ingredients for due orders is as follows:");
        for (int i = 0; i < ordersDue.size(); i++){
            if (ordersDue.get(i).contains(recipeList.get(i))){
                i++;
                System.out.println(recipeList.get(i));
                System.out.println("-----------------------------------------------------------------------");
            }
        }
    }
}
