package structural.composite;

/**
 * Component interface for the Composite pattern.
 * Defines the contract that both leaf and composite objects must follow.
 */
public interface TaskComponent {
    /**
     * Marks this component as completed.
     */
    void complete();
    
    /**
     * Gets the total duration in hours for this component.
     * @return total duration in hours
     */
    int getDuration();
    
    /**
     * Displays the component with proper indentation.
     * @param indent the indentation string to use
     */
    void display(String indent);
    
    /**
     * Gets the name of this component.
     * @return the component name
     */
    String getName();
    
    /**
     * Checks if this component is completed.
     * @return true if completed, false otherwise
     */
    boolean isCompleted();
    
    // Default methods for composite operations
    /**
     * Adds a child component (meaningful only for composites).
     * @param component the component to add
     */
    default void add(TaskComponent component) {
        throw new UnsupportedOperationException("Cannot add to leaf");
    }
    
    /**
     * Removes a child component (meaningful only for composites).
     * @param component the component to remove
     */
    default void remove(TaskComponent component) {
        throw new UnsupportedOperationException("Cannot remove from leaf");
    }
}
