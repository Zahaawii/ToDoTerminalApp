package Task;

import Users.User;

import java.time.LocalDate;

public class Task {

    private int taskID;
    private String taskName;
    private String taskDescription;
    private LocalDate createdDate;
    private LocalDate deadline;
    private boolean isCompleted;
    private String assignedUser;


    public Task(int taskID, String taskName, String taskDescription, LocalDate createdDate , LocalDate deadline, boolean isCompleted, String assignedUser) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.createdDate = createdDate;
        this.deadline = deadline;
        this.isCompleted = isCompleted;
        this.assignedUser = assignedUser;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }


    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskID + "\nTask Name: " + taskName + "\nTask description: " + taskDescription +  "\nDeadline: " + deadline +
                "\nIs completed: " + isCompleted +
                "\nAssigned user: " + assignedUser +
                "\nTask created: " + createdDate;
    }
}
