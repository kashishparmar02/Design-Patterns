package structural.facade;

/**
 * A simple data class to hold all information about an item in stock.
 */
public class StockItem {
    private int count;
    private final String location; // Location is fixed once the item is created

    public StockItem(int count, String location) {
        this.count = count;
        this.location = location;
    }

    public int getCount() {
        return count;
    }

    public String getLocation() {
        return location;
    }

    public void setCount(int count) {
        this.count = count;
    }
}