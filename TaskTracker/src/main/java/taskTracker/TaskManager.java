package taskTracker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jdk.jfr.Description;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private static final String FILE_NAME = "tasks.json";
    private static final Gson gson = new Gson();

    private final List<Task> tasks;

    public TaskManager() {
        this.tasks = loadTasks();
    }

    Scanner sc = new Scanner(System.in);

    public void addTask() {

        System.out.print("Task description: ");
        String description = sc.nextLine();

        System.out.print("Task status(to do; in progress; completed): ");
        String statusInput = sc.nextLine();

        Task.Status status = Task.Status.valueOf(statusInput.toUpperCase().replace(" ", "_"));

        Task t = new Task(description, statusInput, );

        tasks.add(t);
        saveTasks();
    }

    /*
    public void addTask() {

    System.out.print("Task description: ");
    String description = sc.nextLine();

    System.out.print("Task status (to do; in progress; completed): ");
    String statusInput = sc.nextLine();

    Task.Status status = Task.Status.valueOf(statusInput.toUpperCase().replace(" ", "_"));

    Task task = new Task(description, status); // cria a task aqui
    tasks.add(task);
    saveTasks();
}*/

    public void removeTask(Task task) {
        tasks.remove(task);
        saveTasks();
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found");
        } else {
            for (Task t : tasks) {
                System.out.println(t);
            }
        }
    }

    private void saveTasks() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Task> loadTasks() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<ArrayList<Task>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
