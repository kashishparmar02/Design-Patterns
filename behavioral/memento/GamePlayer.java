package behavioral.memento;

public class GamePlayer {
    private int health;
    private int score;
    
    public GamePlayer(int health, int score) {
        this.health = health;
        this.score = score;
    }
    
    public PlayerMemento save() {
        return new PlayerMemento(health, score);
    }
    
    public void restore(PlayerMemento memento) {
        this.health = memento.getHealth();
        this.score = memento.getScore();
    }
    
    public void takeDamage(int damage) { health -= damage; }
    public void addScore(int points) { score += points; }
    
    public void show() {
        System.out.println("Health: " + health + ", Score: " + score);
    }
}
