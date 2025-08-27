package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * The Flyweight Factory.
 * Manages the creation and sharing of Flyweight objects.
 */

public class SoldierFactory {
    // A pool to store the flyweights. In a real app, the key could be soldier type.
    private static final Map<String, Soldier> soldierCache = new HashMap<>();

    /**
     * Gets a soldier. If a soldier of that type already exists, it returns
     * the shared instance. Otherwise, it creates a new one, stores it, and returns it.
     * @param type The type of soldier to get (e.g., "Rifleman").
     * @return A shared Soldier flyweight object.
     */
    public static Soldier getSoldier(String type) {
        Soldier soldier = soldierCache.get(type);

        if (soldier == null) {
            System.out.println("--- Soldier of type '" + type + "' not in cache. Creating a new one. ---");
            soldier = new ConcreteSoldier(); // This is the only place a new heavy object is made.
            soldierCache.put(type, soldier);
        }
        
        return soldier;
    }

    /**
     * A helper method to show how many heavy objects were actually created.
     */
    public static int getTotalSoldierObjectsCreated() {
        return soldierCache.size();
    }
    
}
