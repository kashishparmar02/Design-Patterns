# **State Pattern – Document Workflow Management System**

This project demonstrates the **State Pattern** through a document workflow management system. The pattern allows an object to alter its behavior when its internal state changes, making the object appear to change its class.

## **Project Structure**
```
state/
├── context/
│   └── Document.java                    (Context)
├── states/
│   ├── DocumentState.java               (State Interface)
│   ├── DraftState.java                  (Concrete State)
│   ├── InReviewState.java               (Concrete State)
│   └── PublishedState.java              (Concrete State)
└── Main.java                            (Client/Demo)
```

## **State Transition Process**
1. **Document created** in Draft state with initial content
2. **State-specific operations** performed based on current state
3. **State transitions** occur when valid operations are executed
4. **Behavior changes** automatically as state changes
5. **Invalid operations** are rejected with appropriate messages

## **Pattern Benefits**
* **State Pattern** eliminates complex conditional logic in context object
* Each state encapsulates its own behavior and transition rules
* Easy to add new states without modifying existing code
* State-specific logic is centralized and maintainable
* Object behavior changes dynamically based on internal state
* Follows Open/Closed Principle - open for extension, closed for modification

## **Key Components**

### **Context (Document)**
- Holds reference to current state object
- Delegates all operations to current state
- Provides methods for states to change context's state
- Maintains document content and state information

### **State Interface (DocumentState)**
- `edit(Document, String)` - Edit document content
- `submitForReview(Document)` - Submit document for review
- `approve(Document)` - Approve document for publication
- `reject(Document)` - Reject document back to draft
- `unpublish(Document)` - Unpublish document back to draft

### **Concrete States**

#### **DraftState**
-  **Can edit** content freely
-  **Can submit** for review (transitions to InReview)
-  **Cannot approve/reject** (not under review)
-  **Cannot unpublish** (not published)

#### **InReviewState**
-  **Cannot edit** (document under review)
-  **Cannot submit** (already in review)
-  **Can approve** (transitions to Published)
-  **Can reject** (transitions to Draft)

#### **PublishedState**
-  **Cannot edit** (must unpublish first)
-  **Cannot submit** (already published)
-  **Cannot approve/reject** (already published)
-  **Can unpublish** (transitions to Draft)

## **State Transition Diagram**
```
    ┌─────────┐  submitForReview()  ┌───────────┐
    │  Draft  │ ──────────────────→ │ InReview  │
    │         │ ←────────────────── │           │
    └─────────┘     reject()        └───────────┘
         ↑                               │
         │                               │ approve()
         │                               ▼
         │ unpublish()              ┌───────────┐
         └───────────────────────── │ Published │
                                    └───────────┘
```

## **Running the Demo**
```bash
# Navigate to parent directory of state folder
cd behavioral

# Compile all files
javac -d ../bin state/*.java state/*/*.java

# Run demo
java -cp ../bin behavioral.state.Main
```

The demo demonstrates:
- Document creation in Draft state
- State-specific operation validation
- Automatic state transitions based on operations
- Behavior changes as document moves through workflow
- Complete document lifecycle from draft to published and back

## **Execution Flow Example**
```
New document created in Draft state.
Current Content: "This is a new document."

--- User is editing the draft ---
Cannot approve a document that is in Draft state.     ← State validation
Content updated in Draft state.                       ← Valid operation

--- Submitting for review ---
Submitting for review. State changed from Draft -> InReview.  ← State transition

--- An editor is reviewing ---
Cannot edit a document while it is under review.     ← State validation
Document approved! State changed from InReview -> Published.  ← State transition

--- Document is published ---
Cannot reject a published document.                  ← State validation
Unpublishing document. State changed from Published -> Draft.  ← State transition
```

## **Real-World Applications**
* **Game Development**: Player states (idle, running, jumping, attacking)
* **Order Processing**: Order states (pending, confirmed, shipped, delivered)
* **User Authentication**: User states (logged out, logged in, suspended)
* **Media Players**: Playback states (stopped, playing, paused, buffering)
* **Traffic Lights**: Light states (red, yellow, green)
* **Vending Machines**: Machine states (idle, selecting, dispensing, out of stock)
* **Workflow Systems**: Task states (assigned, in progress, completed, rejected)
* **Banking Systems**: Account states (active, frozen, closed, suspended)
