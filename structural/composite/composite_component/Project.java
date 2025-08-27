package structural.composite.composite_component;

import java.util.ArrayList;
import java.util.List;

import structural.composite.TaskComponent;

/**
 * Composite component in the Composite pattern.
 * Represents a project that can contain both individual tasks and sub-projects.
 */
public class Project implements TaskComponent {
    private String name;
    private String description;
    private List<TaskComponent> tasks;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.tasks = new ArrayList<>();
    }

    @Override
    public void add(TaskComponent task) {
        tasks.add(task);
        System.out.println("Task added to project: " + name);
    }

    @Override
    public void remove(TaskComponent task) {
        tasks.remove(task);
    }

    @Override
    public void complete() {
        System.out.println("Project: " + name + " completed");
        // Recursively complete all child components
        for (TaskComponent task : tasks) {
            task.complete();
        }
    }

    @Override
    public int getDuration() {
        int totalDuration = 0;
        for (TaskComponent task : tasks) {
            totalDuration += task.getDuration();
        }
        return totalDuration;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Project: " + name + " (Description: " + description + ")");
        for (TaskComponent task : tasks) {
            task.display(indent + "  ");
        }
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public boolean isCompleted() {
        // Project is completed only if all its tasks are completed
        for (TaskComponent task : tasks) {
            if (!task.isCompleted()) {
                return false;
            }
        }
        return !tasks.isEmpty();
    }
}
