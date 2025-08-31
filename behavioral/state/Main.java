package behavioral.state;

import behavioral.state.context.Document;

public class Main {
    public static void main(String[] args) {
        // Create a new document. It starts in the "Draft" state.
        Document myDocument = new Document();
        myDocument.show();

        // --- DRAFT WORKFLOW ---
        System.out.println("--- User is editing the draft ---");
        myDocument.approve(); // Fails: Cannot approve a draft.
        myDocument.edit("Updated content for our first document!");
        myDocument.show();

        // --- SUBMIT FOR REVIEW ---
        System.out.println("--- Submitting for review ---");
        myDocument.submitForReview();
        myDocument.show();
        
        // --- REVIEW WORKFLOW ---
        System.out.println("--- An editor is reviewing ---");
        myDocument.edit("Trying to edit during review."); // Fails
        myDocument.approve(); // Success!
        myDocument.show();
        
        // --- PUBLISHED WORKFLOW ---
        System.out.println("--- Document is published ---");
        myDocument.reject(); // Fails
        myDocument.unpublish(); // Success!
        myDocument.show();
        
        System.out.println("--- Document is back in draft for more edits ---");
        myDocument.edit("Adding a final paragraph after unpublishing.");
        myDocument.show();
    }
}
