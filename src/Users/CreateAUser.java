package Users;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateAUser {

    ArrayList <User> createdUsers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int userID = 1;

    private void addUserToArray(int id, String name, String password, String email, int age) {
        User user = new User(userID++ ,name, password, email, age);
        createdUsers.add(user);
    }

    public void createANewUser() {
        System.out.println("Enter your username");
        String name = scanner.next();
        System.out.println("Enter a password");
        String password = scanner.next();
        System.out.println("Enter an email");
        String email = scanner.next();
        System.out.println("Enter your age");
        int age = scanner.nextInt();
        addUserToArray(userID,name, password, email, age);
        System.out.println("Your user: " + name + " has been created");
    }

    public ArrayList<User> getUsers() {
        return createdUsers;
    }

    public void seeUsers() {
        for(User i : getUsers()) {
            System.out.println(i);
        }
    }

    private User getUserID(int id) {
        for(User user : createdUsers) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    private void removeUsersLogic(int id) {
        User user = getUserID(id);
        if(user != null) {
            createdUsers.remove(user);
        }
    }

    public void removeUser() {
        System.out.println("Enter the ID on the user you want to remove");
        int userRemoveID = scanner.nextInt();
        System.out.println("User ID: " + userRemoveID + " has been removed");
        removeUsersLogic(userRemoveID);
    }
}
