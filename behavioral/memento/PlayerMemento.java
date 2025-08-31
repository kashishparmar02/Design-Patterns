package behavioral.memento;

public class PlayerMemento {
    private final int health;
    private final int score;
    
    public PlayerMemento(int health, int score) {
        this.health = health;
        this.score = score;
    }
    
    public int getHealth() { return health; }
    public int getScore() { return score; }
}
