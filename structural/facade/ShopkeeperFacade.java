package structural.facade;

/**
 * The Facade. The shopkeeper provides a simple interface for all shop operations.
 */
public class ShopkeeperFacade {
    private final InventorySystem inventory;

    public ShopkeeperFacade() {
        this.inventory = new InventorySystem();
    }

    public void findAndGetItem(String itemName) {
        System.out.printf("🙋 Customer asks for: '%s'.%n", itemName);
        if (inventory.checkStock(itemName)) {
            String location = inventory.getItemLocation(itemName);
            System.out.printf("  -> Shopkeeper: 'Ah yes, let me get that for you from %s.'%n", location);
            inventory.deductStock(itemName);
            System.out.printf("✅ Here is your '%s'.%n%n", itemName);
        } else {
            System.out.printf("❌ Sorry, '%s' is out of stock.%n%n", itemName);
        }
    }

    /**
     * Facade method to add a new item to the shop's stock.
     */
    public void addNewItemToStock(String itemName, int initialCount, String location) {
        System.out.printf("📦 Shopkeeper is adding a new product to the inventory: '%s'.%n", itemName);
        inventory.addNewItem(itemName, initialCount, location);
        System.out.println("✅ New item added successfully.\n");
    }

    /**
     * Facade method to update the stock count of an existing item.
     */
    public void updateItemStock(String itemName, int newCount) {
        System.out.printf("📦 Shopkeeper is updating stock for an existing item: '%s'.%n", itemName);
        inventory.updateStock(itemName, newCount);
        System.out.println("✅ Stock updated successfully.\n");
    }
    
}
