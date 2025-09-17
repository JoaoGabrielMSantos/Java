package taskTracker;

import java.util.List;
import java.util.Scanner;

public class TaskCLIApp {
    public static void main(String[] args) {
        System.out.println("*------Task Manager------*");
        System.out.println("Select one option:\\n");

        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Update Task");
        System.out.println("4. List Tasks\\n");

        System.out.println("5. Exit");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:

        }
    }
}