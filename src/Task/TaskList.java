package Task;
import UserInterface.ConsoleOperators;
import Users.userManagement;
import Users.User;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskList {

    Scanner scanner = new Scanner(System.in);
    List <Task> createATask = new ArrayList<>();
    int taskID = 1;
    private final userManagement t;

    public TaskList(userManagement t) {
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

    private String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.next();
    }

    public void createNewTask() {
        String taskName = getInput("Enter a task name: ");
        String taskDescription = getInput("Enter a task description: ");

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

    private Task getTaskId(int id) {
    for (Task task : createATask) {
        if(task.getTaskID() == id) {
         return task;
        }
    }
    return null;
    }

    public void finishToDo() {
        System.out.println("Enter the ID on the task you want to complete");
        int id = scanner.nextInt();
       if(getTaskId(id) != null) {
           getTaskId(id).setIsCompleted(true);
           System.out.println(getTaskId(id).getTaskName() + " Task marked as completed");
           removeFromToDo(id);
       }
    }

    private void removeFromToDo(int id) {
        System.out.println("Do you want to remove it from the task list or keep it on the list? Press 'Y' to remove");
        String userInput = scanner.next();
        if(userInput.equalsIgnoreCase("y")) {
            System.out.println(getTaskId(id).getTaskName() + " has been removed from the list");
            createATask.remove(getTaskId(id));
        }
    }

}
