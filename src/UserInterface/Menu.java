package UserInterface;
import java.util.Scanner;

import Task.TaskList;
import Users.CreateAUser;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    CreateAUser userUI = new CreateAUser();
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
        System.out.println("Press a number to go to the menu");

    }

    private int userDecision() {
        int userInput;

        do {
            try {
                userInput = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Wrong input, press a number between 1-5");
                userInput = 0;
            }
        } while (userInput < 1 || userInput > 5);

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
            System.out.println("Delete to do");
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
