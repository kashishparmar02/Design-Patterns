package behavioral.state.states;

import behavioral.state.context.Document;

/**
 * The State interface declares methods that all Concrete States should implement.
 * The Context (Document) will use this interface to delegate actions.
 */
public interface DocumentState {

    void edit(Document document, String newContent);

    void submitForReview(Document document);

    void approve(Document document);

    void reject(Document document);
    
    void unpublish(Document document);
}