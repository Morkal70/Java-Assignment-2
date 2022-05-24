/**Author: Matthew Toon - M1001886*/
package cakemachine;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;


public class CakeMachine {
    private static int menuOption = -1;
    private static String username, cakeToDelete, orderToDelete;
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
        recipeTestData(); //Populates recipeList for testing.
        orderTestData(); //Populates oldOrders, and ordersDue for testing.
        mainMenu(); //Calls getName() to store username, then displays a looping menu.
    }
    private static void mainMenu() {
        if (username == null) {
            getName();
        }
        System.out.println("Welcome to Mclovin's Muffins, " + username + "!");
        while (menuOption != 0) { //The loop will only repeat if the selects a number that isn't 0.
            System.out.println("Select an option\n"
                    + "1. Add recipe \n"
                    + "2. Delete recipe\n"
                    + "3. Add order\n"
                    + "4. Delete order\n"
                    + "5. View old orders\n"
                    + "6. View orders due\n"
                    + "7. View current ingredients required\n"
                    + "0. Exit");

            menuOption = SC.nextInt();

            if (menuOption == 1) { //User navigates menu with numerical keys, numbers 1 through 7 call methods and 0 exits the program.
                addRecipe();
            } else if (menuOption == 2) {
               deleteRecipe();
            } else if (menuOption == 3) {
                addOrder();
            } else if (menuOption == 4) {
                deleteOrder();
            } else if (menuOption == 5) {
                //oldOrders();
                printOldOrders();
            } else if (menuOption == 6) {
                //dueOrders();
                printOrdersDue();
            } else if (menuOption == 7) {
                totalIngredients();
            } else if (menuOption == 0) {
                System.exit(0);
            } else {
                System.out.println("Please select an option from 1 through 7 to proceed, or 0 to exit"); //User error message
            }//End of if statement.
        }//End of while loop.

    }//mainMenu

    private static void recipeTestData() {
        recipeList.add("Vanilla");
        recipeList.add("Ingredients1");
        recipeList.add("Instructions1");
        recipeList.add("Chocolate");
        recipeList.add("Ingredients2");
        recipeList.add("Instructions2");
        recipeList.add("Red Velvet");
        recipeList.add("Ingredients3");
        recipeList.add("Instructions3");
        recipeList.add("Bruce");
        recipeList.add("Ingredients4");
        recipeList.add("Instructions4");
        recipeList.add("Best Cake Ever");
        recipeList.add("Ingredients5");
        recipeList.add("Instructions5");
    }
    
    private static void orderTestData() {
        ordersDue.add("Duncan");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2022-05-27"); //order date
        ordersDue.add("2022-05-30"); //delivery date
        ordersDue.add("Vanilla");
        ordersDue.add("large");
        ordersDue.add("heart");
        ordersDue.add("Duncan2");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2022-05-27"); //order date
        ordersDue.add("2022-05-30"); //delivery date
        ordersDue.add("Chocolate");
        ordersDue.add("large");
        ordersDue.add("heart");
        ordersDue.add("Duncan3");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2022-05-21"); //order date
        ordersDue.add("2022-05-24"); //delivery date
        ordersDue.add("Red Velvet");
        ordersDue.add("large");
        ordersDue.add("heart");

        oldOrders.add("Cher");
        oldOrders.add("contact details");
        oldOrders.add("delivery address");
        oldOrders.add("2022-05-12"); //order date
        oldOrders.add("2022-05-15"); //delivery date
        oldOrders.add("Vanilla");
        oldOrders.add("large");
        oldOrders.add("heart");

//        orderList.add("Cher");
//        orderList.add("contact details");
//        orderList.add("delivery address");
//        orderList.add("2022-05-12");
//        orderList.add("2022-05-15");
//        orderList.add("Vanilla");
//        orderList.add("large");
//        orderList.add("heart");

    }
    
    private static void getName() { //Prompts user for name, then prints text containing their input.
        System.out.println("Please enter your name.");
        username = SC.nextLine();
        System.out.println("Your username: " + username);
    }

    private static void addRecipe(){ //Adds a user input to index 0, another to 1 and another to 2, then prints list for confirmation.
        System.out.println("Please enter the name of the cake.");
        recipeList.add(recipeSC.nextLine());
        System.out.println("Please enter the ingredients.");
        recipeList.add(recipeSC.nextLine());
        System.out.println("Please enter the instructions.");
        recipeList.add(recipeSC.nextLine());
        System.out.println(recipeList);
    }

    private static void deleteRecipe() { //Deletes a full recipe if user inputs matches any indices
        System.out.println("Please enter the name of the cake to delete.");
        cakeToDelete = deleteSC.nextLine();
        for (int i = 0; i < recipeList.size(); i++) {//For loop that iterates through recipeList
            if (recipeList.get(i).contains(cakeToDelete)) {//removes a full recipe if condition is met
                recipeList.remove(i);
                recipeList.remove(i);
                recipeList.remove(i);
            }
        } System.out.println(recipeList);//Displays recipeList once for loop has ended, to confirm any changes.
    }

    private static void addOrder(){ //Adds 8 values into orderList, which are then moved to ordersDue or oldOrders based on the delivery date value
        System.out.println("Please enter the client's name.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the client's contact details.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the delivery address.");
        orderList.add(orderSC.nextLine());
        LocalDate orderDate = LocalDate.now();
        orderList.add(String.valueOf(orderDate)); //automatically adds today's date as string to list
        LocalDate orderDatePlusThree = orderDate.plusDays(3);//Adds 3 days to today's date to generate a delivery date
        orderList.add(String.valueOf(orderDatePlusThree));
        System.out.println("Please enter the type of cake.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the cake size.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the cake shape.");
        orderList.add(orderSC.nextLine());
        System.out.println("orderList: " + orderList);// For checking the contents of orderList

        String deliveryDate = orderList.get(4); //stores index 4 inside new string
        LocalDate date = LocalDate.parse(deliveryDate); //converts deliveryDate string to date object
        LocalDate today = LocalDate.now(); // Stores today's date, for comparisons with deliveryDate
        if (date.compareTo(today) >= 0) {
            System.out.println("delivery date occurs AFTER today's date");//For checking which statement has been executed
            ordersDue.add(orderList.get(0));
            ordersDue.add(orderList.get(1));
            ordersDue.add(orderList.get(2));
            ordersDue.add(orderList.get(3));
            ordersDue.add(orderList.get(4));
            ordersDue.add(orderList.get(5));
            ordersDue.add(orderList.get(6));
            ordersDue.add(orderList.get(7));//Adds 8 elements (1 full order) to the ordersDue list
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);//Removes the same 8 elements from orderList
            System.out.println("orderList: " + orderList);
            System.out.println("ordersDue: " + ordersDue);//For confirming the results of the if statement


        } else if (date.compareTo(today) < 0) {
            System.out.println("delivery date occurs BEFORE today's date");//For checking which statement has been executed
            oldOrders.add(orderList.get(0));
            oldOrders.add(orderList.get(1));
            oldOrders.add(orderList.get(2));
            oldOrders.add(orderList.get(3));
            oldOrders.add(orderList.get(4));
            oldOrders.add(orderList.get(5));
            oldOrders.add(orderList.get(6));
            oldOrders.add(orderList.get(7));//Adds 8 elements (1 full order) to the oldOrders list
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);
            orderList.remove(0);//Removes the same 8 elements from orderList
            System.out.println("orderList: "+ orderList);
            System.out.println("oldOrders: "+ oldOrders);//For confirming the results of the if statement
        } else {
            System.out.println("Something went wrong");//For identifying comparison errors
        }
    }
    private static void deleteOrder(){//Deletes a full order if user inputs matches any indices
        System.out.println("Please enter the name of the client to delete their order.");
        orderToDelete = deleteOrderSC.nextLine();
        for (int i = 0; i < ordersDue.size(); i++) {//For loop that iterates through ordersDue
            if (ordersDue.get(i).contains(orderToDelete)) {//removes a full order if condition is met
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
            }
        } 
        System.out.println("ordersDue: " + ordersDue);//Displays ordersDue once for loop has ended, to confirm any changes.
    }

    private static void printOldOrders() {//Prints all elements stored in oldOrders
        System.out.println("Old orders:\n");
        for (int i = 0; i < oldOrders.size(); i++) {
            System.out.println(oldOrders.get(i));
            if (i % 8 == 7) { //Adds a string of hyphens to separate each order
                System.out.println("-----------------------------------------------------------------------");
            }
        }
    }
    private static void printOrdersDue(){//Prints all elements stored in ordersDue
        System.out.println("Orders due:\n");
        for (int i = 0; i < ordersDue.size(); i++) {
            System.out.println(ordersDue.get(i));
                if (i % 8 == 7) {//Adds a string of hyphens to separate each order
                    System.out.println("-----------------------------------------------------------------------");
                }
        }
    }

    private static void totalIngredients(){ 
        System.out.println("The ingredients for due orders are as follows:\n");
//        for (int i = 0; i < ordersDue.size()-1; i++){
//            System.out.println(ordersDue.size());
//            System.out.println(ordersDue.toString()+i);
//            if (ordersDue.get(i).contains("Vanilla")){
//                i++;
//                System.out.println(recipeList);
//                System.out.println("-----------------------------------------------------------------------");
//            }
//        }
//Failed implementation #1


//        int index = 0;
//        for (String lineOfCake : ordersDue){
//            System.out.println(lineOfCake);
//            if (lineOfCake.contains(ordersDue.get(0))){
//                index = recipeList.indexOf(recipeList);
//                System.out.println(recipeList.get(1));
//                System.out.println("-----------------------------------------------------------------------");
//            }
//Failed implementation #2, prints Ingredients1 as many times as there are orders, rather than a new Ingredient set each time


//        String lineOfRecipes = String.valueOf(recipeList);
//        String lineOfOrders = String.valueOf(ordersDue);
        for (int i = 0; i < ordersDue.size(); i++) {
            if (ordersDue.contains(recipeList.get(i))) {
                i++;//Increments by one, because the index after a cake name will always be the ingredients
                System.out.println(recipeList.get(i));//Prints the ingredients for 1 cake
                System.out.println("-----------------------------------------------------------------------");//Separates each set of ingredients
            }
        }//Works, but crashes program when recipeList has more indices than ordersDue
    }
}
 