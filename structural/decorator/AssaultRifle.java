package structural.decorator;

/**
 * Concrete Component: The base weapon object that decorators will wrap.
 */
public class AssaultRifle implements Weapon {
    @Override
    public String fire() {
        return "Firing assault rifle with a loud bang!";
    }

    @Override
    public String getDescription() {
        return "Assault Rifle";
    }

    @Override
    public double getDamage() {
        return 45.0; // Base damage
    }

    @Override
    public double getAccuracy() {
        return 75.0; // Base accuracy
    }
}