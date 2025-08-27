package structural.facade;

import java.util.HashMap;
import java.util.Map;

/**
 * The complex subsystem, refactored to use a single map of StockItem objects.
 */

public class InventorySystem {
    private final Map<String, StockItem> inventory = new HashMap<>();

    public InventorySystem() {
        inventory.put("Parker Pen", new StockItem(10, "Aisle 3, Shelf B"));
    }

    public boolean checkStock(String itemName) {
        System.out.printf("  -> [Inventory] Checking stock for '%s'.%n", itemName);
        StockItem item = inventory.get(itemName);
        return item != null && item.getCount() > 0;
    }

    public String getItemLocation(String itemName) {
        System.out.printf("  -> [Inventory] Finding location for '%s'.%n", itemName);
        StockItem item = inventory.get(itemName);
        return (item != null) ? item.getLocation() : "an unknown location";
    }

    public void deductStock(String itemName) {
        System.out.printf("  -> [Inventory] Deducting 1 unit of '%s' from stock.%n", itemName);
        inventory.get(itemName).setCount(inventory.get(itemName).getCount() - 1);
    }

    public void addNewItem(String itemName, int initialCount, String location) {
        System.out.printf("  -> [Inventory] Adding new item '%s'.%n", itemName);
        inventory.put(itemName, new StockItem(initialCount, location));
    }

    public void updateStock(String itemName, int newCount) {
        StockItem item = inventory.get(itemName);
        if (item != null) {
            System.out.printf("  -> [Inventory] Updating stock for '%s' from %d to %d units.%n",
                              itemName, item.getCount(), newCount);
            item.setCount(newCount);
        } else {
            System.out.printf("  -> [Inventory] Error: Cannot update stock for '%s'.%n", itemName);
        }
    }
}
