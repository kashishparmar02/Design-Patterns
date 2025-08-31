package behavioral.state.states;

import behavioral.state.context.Document;

public class PublishedState implements DocumentState {

    @Override
    public void edit(Document document, String newContent) {
        System.out.println("Cannot edit a published document directly. Please unpublish first.");
    }

    @Override
    public void submitForReview(Document document) {
        System.out.println("A published document cannot be submitted for review.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("The document is already published.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject a published document.");
    }
    
    @Override
    public void unpublish(Document document) {
        System.out.println("Unpublishing document. State changed from Published -> Draft.");
        document.setState(new DraftState());
    }
}