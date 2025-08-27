package structural.composite;

import structural.composite.client.TaskManager;
import structural.composite.composite_component.Project;
import structural.composite.leaf.Task;

/**
 * Demonstrates the Composite Design Pattern implementation.
 * Shows how individual tasks and project compositions can be
 * treated uniformly through a common interface.
 */
public class CompositeDemo {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager("Kashish Parmar");

        // Create individual tasks (leaf components)
        Task task1 = new Task("Design API", "Nij Akbari", 10);
        Task task2 = new Task("Write tests", "Paresh", 3);
        Task task3 = new Task("Deploy", "Dhaval", 1);

        // Create project and add tasks (composite component)
        Project webProject = new Project("Web APP", "Develop a web application");
        webProject.add(task1);
        webProject.add(task2);
        webProject.add(task3);

        // Create main project with sub-project and individual task
        Project fullProject = new Project("Full Project", "end to end project");
        fullProject.add(webProject);
        fullProject.add(new Task("Marketing Campaign", "Diana", 20));

        System.out.println("Initial Status");
        manager.showStatus(fullProject);

        // Demonstrate individual task completion
        System.out.println("=== COMPLETING INDIVIDUAL TASK ===");
        manager.completeWork(task1); // Complete just one task
        manager.showStatus(webProject);

        // Demonstrate composite completion (recursive)
        System.out.println("=== COMPLETING ENTIRE PROJECT ===");
        manager.completeWork(webProject); // Complete entire project (and all its tasks!)
        manager.showStatus(fullProject);
    }
}
