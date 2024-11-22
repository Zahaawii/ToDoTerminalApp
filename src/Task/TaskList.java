package Task;
import UserInterface.ConsoleOperators;
import Users.CreateAUser;
import Users.User;

import java.io.Console;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskList {

    Scanner scanner = new Scanner(System.in);
    List <Task> createATask = new ArrayList<>();
    int taskID = 1;
    private final CreateAUser t;

    public TaskList(CreateAUser t) {
        this.t = t;
    }

    public void addTaskToArray(int id, String taskName, String taskDescription, LocalDate createdTask ,LocalDate deadline, boolean isCompleted, String user) {
        Task task = new Task(taskID++, taskName, taskDescription, createdTask, deadline, isCompleted, user);
        createATask.add(task);
    }

    public String getUsersInformation(int id) {
        for(User user : t.getUsers()) {
            if(user.getId() == id) {
                return user.getName();
            }
        }
        return null;
    }

    public List<Task> getTask() {
        return createATask;
    }

    public void createNewTask() {
        System.out.println("Add a new task");
        String taskName = scanner.next();
        System.out.println("Task description");
        String taskDescription = scanner.next();

        System.out.println("Enter the date for when the task shall be done. Enter the input like 2024-12-03 ");
        LocalDate dueDate = null;

        do {
            try {
                dueDate = LocalDate.parse(scanner.next());
            } catch (DateTimeParseException e) {
                System.out.println("Wrong date input, Enter the input like YYYY-MM-DD");
            }
        } while (dueDate == null);

        LocalDate date = LocalDate.now();
        boolean isCompleted = false;

        System.out.println("Enter the id of your account");
        int userID = scanner.nextInt();


        addTaskToArray(taskID, taskName, taskDescription, date, dueDate, isCompleted, getUsersInformation(userID));
    }

    public void seeAllTask() {
        for(Task i : getTask()) {
            ConsoleOperators.printSeperator(30);
            System.out.println(i);
        }
    }

}
