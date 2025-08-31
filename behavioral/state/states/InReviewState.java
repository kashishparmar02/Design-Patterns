package behavioral.state.states;

import behavioral.state.context.Document;

public class InReviewState implements DocumentState {

    @Override
    public void edit(Document document, String newContent) {
        System.out.println("Cannot edit a document while it is under review.");
    }

    @Override
    public void submitForReview(Document document) {
        System.out.println("Document is already under review.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Document approved! State changed from InReview -> Published.");
        document.setState(new PublishedState());
    }

    @Override
    public void reject(Document document) {
        System.out.println("Document rejected. State changed from InReview -> Draft.");
        document.setState(new DraftState());
    }
    
    @Override
    public void unpublish(Document document) {
        System.out.println("Cannot unpublish a document that is not published yet.");
    }
}