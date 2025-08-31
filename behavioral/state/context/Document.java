package behavioral.state.context;

import behavioral.state.states.DocumentState;
import behavioral.state.states.DraftState;

/**
 * The Context class holds a reference to the current state and delegates
 * all state-specific work to it.
 */
public class Document {

    private DocumentState currentState;
    private String content;

    public Document() {
        // A new document starts in the Draft state.
        this.currentState = new DraftState();
        this.content = "This is a new document.";
        System.out.println("New document created in Draft state.");
    }

    // Methods for the state objects to change the context's state.
    public void setState(DocumentState state) {
        this.currentState = state;
    }

    // Method for state objects to modify the context's data.
    public void setContent(String content) {
        this.content = content;
    }

    // The context delegates the work to the current state object.
    public void edit(String newContent) {
        currentState.edit(this, newContent);
    }

    public void submitForReview() {
        currentState.submitForReview(this);
    }

    public void approve() {
        currentState.approve(this);
    }
    
    public void reject() {
        currentState.reject(this);
    }

    public void unpublish() {
        currentState.unpublish(this);
    }

    public void show() {
        System.out.println("Current Content: \"" + content + "\"\n");
    }
}