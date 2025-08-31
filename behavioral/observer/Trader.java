package behavioral.observer;
public class Trader implements Observer {
    private String name;
    
    public Trader(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String stock, double price) {
        System.out.println(name + ": " + stock + " is now $" + price);
    }
}