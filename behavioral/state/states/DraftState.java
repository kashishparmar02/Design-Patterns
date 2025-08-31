package behavioral.state.states;

import behavioral.state.context.Document;

public class DraftState implements DocumentState {

    @Override
    public void edit(Document document, String newContent) {
        document.setContent(newContent);
        System.out.println("Content updated in Draft state.");
    }

    @Override
    public void submitForReview(Document document) {
        System.out.println("Submitting for review. State changed from Draft -> InReview.");
        document.setState(new InReviewState());
    }

    @Override
    public void approve(Document document) {
        System.out.println("Cannot approve a document that is in Draft state.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject a document that is in Draft state.");
    }
    
    @Override
    public void unpublish(Document document) {
        System.out.println("Cannot unpublish a document that is not published.");
    }
}