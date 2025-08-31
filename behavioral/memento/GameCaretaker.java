package behavioral.memento;

public class GameCaretaker {
    private PlayerMemento savedState;
    
    public void saveGame(GamePlayer player) {
        savedState = player.save();
        System.out.println("Game saved!");
    }
    
    public void loadGame(GamePlayer player) {
        if (savedState != null) {
            player.restore(savedState);
            System.out.println("Game loaded!");
        }
    }
}
