package structural.flyweight;

/**
 * The Flyweight interface.
 * It defines the contract for objects that can be shared.
 * The extrinsic state is passed to its methods.
 */
public interface Soldier {
    /**
     * Renders a soldier at a given location with a given health.
     * @param x The soldier's X coordinate.
     * @param y The soldier's Y coordinate.
     * @param currentHealth The soldier's current health.
     */
    void render(int x, int y, int currentHealth);
}