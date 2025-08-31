package behavioral.observer;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<Observer> observers = new ArrayList<>();
    private String symbol;
    private double price;
    
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    public void setPrice(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        notifyObservers();
    }
    
    private void notifyObservers() {
        for (Observer observer : observers) {
            try {
                observer.update(symbol, price);
            } catch (Exception e) {
                System.err.println("Observer failed: " + e.getMessage());
            }
        }
    }
}