package Users;
import UserInterface.ConsoleOperators;

import java.util.ArrayList;
import java.util.Scanner;

public class userManagement {

    ArrayList<User> createdUsers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int userID = 1;

    private void addUserToArray(int id, String name, String password, String email, int age) {
        User user = new User(userID++, name, password, email, age);
        createdUsers.add(user);
    }

    public void createANewUser() {
        String name = getInput("Enter your username");
        String password = getInput("Enter your password");
        String email = getInput("Enter your email");
        int age = getAge();
        addUserToArray(userID, name, password, email, age);
        System.out.println("Your user: " + name + " has been created");
    }

    private String getInput(String prompt) {
        System.out.println(prompt);
        ConsoleOperators.printSeperator(30);
        return scanner.next();
    }

    private int getAge() {
        int age;

        do {
            System.out.println("Enter your age");
            try {
                age = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid age between 1-99");
                age = -1;
            }
        } while (age < 1 || age > 99);
        return age;

    }

    public ArrayList<User> getUsers() {
        return createdUsers;
    }

    public void seeUsers() {
        for (User i : getUsers()) {
            System.out.println(i);
        }
    }

    private User getUserID(int id) {
        for (User user : createdUsers) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    private User getUserName(int id) {
        for (User user : createdUsers) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    private void removeUsersLogic(int id) {
        User user = getUserID(id);
        if (user != null) {
            createdUsers.remove(user);
        }
    }

    public void removeUser() {
        removeUserAfterInput();
    }

    private int removeUserInput() {
        int userRemoveID;

        do {
            System.out.println("Enter the ID on the user you want to remove");
            try {
                userRemoveID = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid ID");
                userRemoveID = -1;
            }
        } while (userRemoveID < 1 || userRemoveID > 1000);
        return userRemoveID;
    }

    private void removeUserAfterInput() {
        int userRemoveID = removeUserInput();

        User user = getUserName(userRemoveID);
        if(user != null) {
          if(userRemoveID == user.getId()) {
              System.out.println("User: " + user.getName() + "\nUser ID: " + userRemoveID + " has been removed");
              removeUsersLogic(userRemoveID);
          } else {
              System.out.println("User does not exist.");
          }
        } else {
            System.out.println("No members instantiated. Going back to menu");
        }
    }
}
