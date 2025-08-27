package structural.composite.leaf;

import structural.composite.TaskComponent;

/**
 * Leaf component in the Composite pattern.
 * Represents an individual task that cannot have child components.
 */
public class Task implements TaskComponent {
    private String name;
    private String assignee;
    private int duration;
    private boolean completed;

    public Task(String name, String assignee, int duration) {
        this.name = name;
        this.assignee = assignee;
        this.duration = duration;
        this.completed = false;
    }

    @Override
    public void complete() {
        if (!completed) {
            completed = true;
            System.out.println("Task done: " + name + " completed by " + assignee);
        }
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void display(String indent) {
        String status = completed ? "Completed" : "Pending";
        System.out.println(indent + "Task: " + name + " (Assigned to: " + assignee + ", Duration: " + duration + " hours, Status: " + status + ")");
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public boolean isCompleted() {
        return completed;
    }
}
