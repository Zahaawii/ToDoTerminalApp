package Users;

public class User {

    private int userID;
    private String name;
    private String password;
    private String email;
    private int age;

    public User(int userID, String name, String password, String email, int age) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return userID;
    }

    @Override
    public String toString() {
        return "ID: " + userID + " Name: " + name + " Password: " + password + " Email: " + email + " Age: " + age;
    }
}
