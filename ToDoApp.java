import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    String title;
    String description;
    boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }
}

class ToDoList {
    List<Task> tasks = new ArrayList<>();

    void addTask(Task task) {
        tasks.add(task);
    }

    void viewTasks() {
        System.out.println("To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.title + " - " + task.description + " (" + (task.completed ? "Completed" : "Pending") + ")");
        }
    }

    void markTaskAsCompleted(int taskId) {
        if (taskId >= 1 && taskId <= tasks.size()) {
            Task task = tasks.get(taskId - 1);
            task.completed = true;
            System.out.println("Task marked as completed: " + task.title);
        } else {
            System.out.println("Invalid task ID");
        }
    }
}

public class ToDoApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(new Task(title, description));
                    System.out.println("Task added!");
                    break;
                case 2:
                    toDoList.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter task ID to mark as completed: ");
                    int taskId = scanner.nextInt();
                    toDoList.markTaskAsCompleted(taskId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
