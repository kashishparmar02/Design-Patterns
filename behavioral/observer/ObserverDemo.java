package behavioral.observer;
public class ObserverDemo {
    public static void main(String[] args) {
        Stock stock = new Stock();
        
        stock.addObserver(new Trader("John"));
        stock.addObserver(new Trader("Alice"));
        stock.setPrice("AAPL", 150.50);
        stock.setPrice("GOOGL", 2750.75);
        stock.setPrice("MSFT", 100.75);
    }
}