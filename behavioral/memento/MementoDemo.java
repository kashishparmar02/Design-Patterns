package behavioral.memento;

public class MementoDemo {
    public static void main(String[] args) {
    // 1. Create all objects
    GamePlayer player = new GamePlayer(100, 0);     // Originator
    GameCaretaker caretaker = new GameCaretaker();  // Caretaker
    
    // 2. Show initial state
    player.show(); // "Health: 100, Score: 0"
    
    // 3. SAVE PROCESS
    caretaker.saveGame(player);  // Caretaker asks player to save
    // Inside saveGame():
    // savedState = player.save()  <- Player creates memento
    // Caretaker now holds memento but can't see inside it
    
    // 4. Change player state
    player.addScore(500);
    player.takeDamage(30);
    player.show(); // "Health: 70, Score: 500"
    
    // 5. RESTORE PROCESS  
    caretaker.loadGame(player);  // Caretaker gives memento back to player
    // Inside loadGame():
    // player.restore(savedState)  <- Player uses memento to restore
    
    player.show(); // "Health: 100, Score: 0" - RESTORED!
}
}