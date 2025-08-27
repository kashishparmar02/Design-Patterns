package structural.flyweight;

import java.util.Random;

/**
 * The Client class that uses the Flyweight pattern.
 */

public class Game {
    private static final int TOTAL_SOLDIERS_TO_RENDER = 10;

    public static void main(String[] args) {
        System.out.println("Starting the game...");
        Random random = new Random();

        // The game loop to render the entire army.
        for (int i = 0; i < TOTAL_SOLDIERS_TO_RENDER; i++) {
            // Get a shared soldier object from the factory.
            Soldier soldier = SoldierFactory.getSoldier("Rifleman");

            // Generate unique, extrinsic state for this soldier instance.
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            int health = 75 + random.nextInt(26); // Health between 75 and 100

            // Pass the extrinsic state to the shared flyweight object to render.
            soldier.render(x, y, health);
        }

        System.out.println("\n--- BATTLE FINISHED ---");
        System.out.printf("Total soldiers rendered: %d%n", TOTAL_SOLDIERS_TO_RENDER);
        System.out.printf("Total HEAVY soldier objects actually created: %d%n",
                          SoldierFactory.getTotalSoldierObjectsCreated());
    }
}
