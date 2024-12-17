package UserInterface;
import java.io.Console;
import java.util.Scanner;

import Task.TaskList;
import Users.userManagement;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    userManagement userUI = new userManagement();
    TaskList list = new TaskList(userUI);

    public void UI() {
        displayText();
        userMenu();
    }

    private void displayText() {
        System.out.println("Welcome to the Zahaawis To do");
        ConsoleOperators.printSeperator(30);
        System.out.println("You have following choices");
        ConsoleOperators.printSeperator(30);
        System.out.println("Press 1: See to do \nPress 2: Add to do " +
                "\nPress 3: Delete from do" +
                " \nPress 4: Create a new user \nPress 5: See all users created \nPress 6: Remove an user");
        ConsoleOperators.printSeperator(30);

    }

    private int userDecision() {
        int userInput;

        do {
            System.out.println("Enter a number between 1-6");
            try {
                userInput = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Wrong input, press a number between 1-5");
                userInput = 0;
            }
        } while (userInput < 1 || userInput > 6);

        return userInput;
    }

    private void userMenu() {
        int userInput = userDecision();

        if(userInput == 1 ) {
            System.out.println("See To do");
            list.seeAllTask();
        }
        if(userInput == 2) {
            System.out.println("Add to do");
            list.createNewTask();
        }

        if(userInput == 3) {
            System.out.println("Complete to do");
            list.finishToDo();
        }

        if(userInput == 4) {
            System.out.println("Create a new user");
            userUI.createANewUser();
        }

        if(userInput == 5) {
            System.out.println("See all users created");
            userUI.seeUsers();
        }

        if(userInput == 6) {
            System.out.println("Remove a user");
            userUI.removeUser();
        }
    }
}
