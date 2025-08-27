package structural.facade;

/**
 * The Client. A manager interacts with the ShopkeeperFacade to run the shop.
 */
public class ShopManagerClient {
    public static void main(String[] args) {
        ShopkeeperFacade shopkeeper = new ShopkeeperFacade();

        // --- A customer comes in ---
        shopkeeper.findAndGetItem("Parker Pen");

        // --- Manager adds a new product that was previously out of stock ---
        System.out.println("--- Manager is adding a new product ---");
        shopkeeper.findAndGetItem("Fancy Notebook"); // Check first, shows it's out of stock
        shopkeeper.addNewItemToStock("Fancy Notebook", 20, "Aisle 1, Shelf C");
        shopkeeper.findAndGetItem("Fancy Notebook"); // Customer can now buy it

        // --- Manager updates stock for an existing item after a new shipment arrives ---
        System.out.println("--- Manager is updating existing stock ---");
        shopkeeper.updateItemStock("Parker Pen", 50);
    }
}
