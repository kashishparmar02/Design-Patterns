package structural.composite.client;

import structural.composite.TaskComponent;

/**
 * Client class that demonstrates the Composite pattern usage.
 * Manages task operations and provides reporting functionality.
 */
public class TaskManager {
    private String managerName;

    public TaskManager(String managerName) {
        this.managerName = managerName;
    }

    public void showStatus(TaskComponent task) {
        System.out.println("Manager: " + managerName);
        task.display("");
        System.out.println("Total Duration: " + task.getDuration() + " hours");
        System.out.println("--------------------------------");
    }

    public void completeWork(TaskComponent task) {
        System.out.println("Manager: " + managerName + " is completing work on " + task.getName());
        task.complete();
        System.out.println("Work completed: " + task.getName());
        System.out.println("--------------------------------");
    }
}
