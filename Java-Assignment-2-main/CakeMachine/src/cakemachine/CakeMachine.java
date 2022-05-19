/**Author: Matthew Toon - M1001886*/
package cakemachine;

import java.util.Date;
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
        recipeTestData();
        orderTestData();
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
                oldOrders();
            } else if (menuOption == 6) {
                dueOrders();
            } else if (menuOption == 7) {
                totalIngredients();
            } else if (menuOption == 0) {
                System.exit(0);
            } else {
                System.out.println("Please select an option from 1 through 7 to proceed, or 0 to exit");
            }// end of IF statement
        }//end of while loop

    }//mainMenu

    private static void recipeTestData() {
        recipeList.add("Vanilla");
        recipeList.add("Ingredients");
        recipeList.add("Instructions");
        recipeList.add("Chocolate");
        recipeList.add("Ingredients");
        recipeList.add("Instructions");
        recipeList.add("Vanilla");
        recipeList.add("Ingredients");
        recipeList.add("Instructions");
        
    }
    
    private static void orderTestData() {
        ordersDue.add("Duncan");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2022-05-10"); //order date
        ordersDue.add("2022-05-13"); //delivery date
        ordersDue.add("Chocolate");
        ordersDue.add("large");
        ordersDue.add("heart");
        ordersDue.add("Duncan");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2022-05-19"); //order date
        ordersDue.add("2022-05-22"); //delivery date
        ordersDue.add("Vanilla");
        ordersDue.add("large");
        ordersDue.add("heart");
        ordersDue.add("Duncan1");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2022-05-19"); //order date
        ordersDue.add("2022-05-22"); //delivery date
        ordersDue.add("Vanilla");
        ordersDue.add("large");
        ordersDue.add("heart");
        
    }
    
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
        System.out.println("orderList: " + orderList);

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
        } 
        System.out.println("orderList: " + orderList);
    }
    //https://stackoverflow.com/questions/33968333/how-to-check-if-a-string-is-date
    //https://www.tutorialspoint.com/how-to-compare-two-dates-in-java
    private static void oldOrders(){
        String deliveryDate = orderList.get(4); //stores index 4 inside new string
        LocalDate date = LocalDate.parse(deliveryDate); // converts delivery date string to actual date
        LocalDate today = LocalDate.now();
        if (date.compareTo(today) > 0) {
            System.out.println("delivery date occurs AFTER today's date");
            ordersDue.add(orderList.get(0));
            ordersDue.add(orderList.get(1));
            ordersDue.add(orderList.get(2));
            ordersDue.add(orderList.get(3));
            ordersDue.add(orderList.get(4));
            ordersDue.add(orderList.get(5));
            ordersDue.add(orderList.get(6));
            ordersDue.add(orderList.get(7));
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            System.out.println("ordersDue: " + ordersDue);
            System.out.println("orderList: " + orderList);
            
        } else if (date.compareTo(today) < 0) {
            System.out.println("delivery date occurs BEFORE today's date"); //move elements 0-7 to new list, print list
            oldOrders.add(orderList.get(0));
            oldOrders.add(orderList.get(1));
            oldOrders.add(orderList.get(2));
            oldOrders.add(orderList.get(3));
            oldOrders.add(orderList.get(4));
            oldOrders.add(orderList.get(5));
            oldOrders.add(orderList.get(6));
            oldOrders.add(orderList.get(7));
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            System.out.println("oldOrders: "+ oldOrders);
            System.out.println("orderList: "+ orderList);
            
        } else if (date.compareTo(today) == 0) {
            System.out.println("delivery date is today");
            ordersDue.add(orderList.get(0));
            ordersDue.add(orderList.get(1));
            ordersDue.add(orderList.get(2));
            ordersDue.add(orderList.get(3));
            ordersDue.add(orderList.get(4));
            ordersDue.add(orderList.get(5));
            ordersDue.add(orderList.get(6));
            ordersDue.add(orderList.get(7));
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            System.out.println("ordersDue: " + ordersDue);
            System.out.println("orderList: " + orderList);          
        } else {
            System.out.println("ordersDue: " + ordersDue);
        }
        //if (orderList != null) {
        //    oldOrders();
        //} else {
        //    mainMenu();
        //}
       
        //repeat process if index 4 is still populated
        //finish by printing list
    }
    
    private static void dueOrders(){
        //same idea as oldOrders, but check if delivery date is AFTER today, or == today, then move entire order to new list, print list
        String deliveryDate = orderList.get(4);
        LocalDate date = LocalDate.parse(deliveryDate);
        LocalDate today = LocalDate.now();
        if (date.compareTo(today) > 0) {
            System.out.println("delivery date occurs AFTER today's date");
            ordersDue.add(orderList.get(0));
            ordersDue.add(orderList.get(1));
            ordersDue.add(orderList.get(2));
            ordersDue.add(orderList.get(3));
            ordersDue.add(orderList.get(4));
            ordersDue.add(orderList.get(5));
            ordersDue.add(orderList.get(6));
            ordersDue.add(orderList.get(7));
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            System.out.println("ordersDue: " + ordersDue);
            System.out.println("orderList: " + orderList); 
            
        } else if (date.compareTo(today) < 0) {
            System.out.println("delivery date occurs BEFORE today's date"); //move elements 0-7 to new list, print list
            oldOrders.add(orderList.get(0));
            oldOrders.add(orderList.get(1));
            oldOrders.add(orderList.get(2));
            oldOrders.add(orderList.get(3));
            oldOrders.add(orderList.get(4));
            oldOrders.add(orderList.get(5));
            oldOrders.add(orderList.get(6));
            oldOrders.add(orderList.get(7));
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            System.out.println("oldOrders: "+ oldOrders);
            System.out.println("orderList: "+ orderList);
            
        } else if (date.compareTo(today) == 0) {
            System.out.println("delivery date is today");
            ordersDue.add(orderList.get(0));
            ordersDue.add(orderList.get(1));
            ordersDue.add(orderList.get(2));
            ordersDue.add(orderList.get(3));
            ordersDue.add(orderList.get(4));
            ordersDue.add(orderList.get(5));
            ordersDue.add(orderList.get(6));
            ordersDue.add(orderList.get(7));
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            System.out.println("ordersDue: " + ordersDue);
            System.out.println("orderList: " + orderList);
        } 
        
    }
    private static void totalIngredients(){ 
        System.out.println("The ingredients for due orders are as follows:");
//        for (int i = 0; i < ordersDue.size()-1; i++){
//            System.out.println(ordersDue.size());
//            System.out.println(ordersDue.toString()+i);
//            if (ordersDue.get(i).contains("Vanilla")){
//                i++;
//                System.out.println(recipeList);
//                System.out.println("-----------------------------------------------------------------------");
//            }
//        }

        
        int index = 0; 
        int count = 0;
        for (String lineOfCake : ordersDue){
            count++;
            
             if (lineOfCake.contains(ordersDue.get(0))){
                index = recipeList.indexOf(recipeList);
                System.out.println(recipeList.get(1));
                System.out.println("-----------------------------------------------------------------------");
            }
        }
    }
}
 