/**Author: Matthew Toon - M1001886*/
package cakemachine;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class CakeMachine {
    private static int menuOption = -1;
    private static String username, cakeName, ingredients, instructions, cakeToDelete;
    private static String cakeArray[] = new String[3];
    private static ArrayList<String[]> recipeList = new ArrayList<String[]>();
    private static Scanner SC = new Scanner(System.in);
    private static Scanner recipeSC = new Scanner(System.in);
    private static Scanner deleteSC = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    /**public class Recipe(String cakeName, String ingredients, String instructions) {


    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(cakeName) {
        this.cakeName = cakeName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    //public void setInstructions(instructions) {
        this.ingredients = ingredients;
    }
}*/  // should this bracket encapsulate?

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
                //addRecipeObject
                addRecipeArray();
            } else if (menuOption == 2) {
                //deleteRecipeObject
                deleteRecipeArray();
            } else if (menuOption == 3) {
                //addOrder();
            } else if (menuOption == 4) {
                //deleteOrder();
            } else if (menuOption == 5) {
                //oldOrders();
            } else if (menuOption == 6) {
                //ordersDue();
            } else if (menuOption == 7) {
                //totalIngredients();
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

   /** private static void addRecipeObject() {
        Recipe recipe = new Recipe();
        recipe.setCakeName();
        recipe.setIngredients();
        System.out.println("Please enter the cake name");
        cakeName = recipeSC.nextLine();
        recipeList.add(cakeName);
        System.out.println("Please enter the cake ingredients");
        ingredients = recipeSC.nextLine();
        recipeList.add(ingredients);
        System.out.println("Please enter the cake instructions");
        instructions = recipeSC.nextLine();
        recipeList.add(instructions);

    }*/

    private static void addRecipeArray(){
        System.out.println("Please enter the cake name");
        cakeArray[0] = recipeSC.nextLine();
        System.out.println("Please enter the cake ingredients");
        cakeArray[1] = recipeSC.nextLine();
        System.out.println("Please enter the cake instructions");
        cakeArray[2] = recipeSC.nextLine();
        System.out.println("You entered: " + Arrays.toString(cakeArray));
        recipeList.add(cakeArray);
        System.out.println(Arrays.deepToString(recipeList.toArray()));

    }
    /**private static void deleteRecipeObject() {
        System.out.println("Please enter the name of the cake.");
        cakeName = deleteSC.nextLine();
      for (int i=0; i<recipeList.size(); i++) {
          if (recipeList.get(i).cakeName.equals(cakeName)); {
              recipeList.remove(i);
              break;
          }
      }
    }*/

    private static void deleteRecipeArray(){
        System.out.println("Please enter the name of the cake to delete.");
        cakeName = deleteSC.nextLine();
        

    }



}