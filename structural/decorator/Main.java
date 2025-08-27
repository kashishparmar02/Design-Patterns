package structural.decorator;

/**
 * The main client class to showcase the Decorator pattern.
 */
public class Main {

    public static void main(String[] args) {
        // Create a base weapon
        Weapon myRifle = new AssaultRifle();
        printWeaponStats("Base Weapon", myRifle);

        // --- Loadout 1: A stealthy rifle with a premium skin ---
        // We wrap the base rifle with a silencer, then a scope, and finally a skin.
        Weapon stealthRifle = new SkinDecorator(
                                  new ScopeDecorator(
                                      new SilencerDecorator(myRifle)
                                  ), "Crimson Web"
                              );
        printWeaponStats("Stealth Loadout", stealthRifle);

        // --- Loadout 2: A high-damage rifle with a different skin ---
        // Note: We are re-using the same 'myRifle' base object.
        Weapon heavyHitterRifle = new SkinDecorator(
                                      new MuzzleDecorator(
                                          new ScopeDecorator(myRifle)
                                      ), "Gold Rush"
                                  );
        printWeaponStats("Heavy Hitter Loadout", heavyHitterRifle);
    }

    /**
     * Helper method to print the details of a weapon configuration.
     */
    public static void printWeaponStats(String loadoutName, Weapon weapon) {
        System.out.println("--- " + loadoutName + " ---");
        System.out.println("Description: " + weapon.getDescription());
        System.out.println("Damage: " + weapon.getDamage());
        System.out.println("Accuracy: " + weapon.getAccuracy());
        System.out.println("Action: " + weapon.fire());
        System.out.println();
    }
}