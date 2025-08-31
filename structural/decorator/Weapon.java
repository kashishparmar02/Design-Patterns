package structural.decorator;

/**
 * Component Interface: Defines the common contract for a weapon and its attachments.
 */
public interface Weapon {
    /**
     * Describes the firing action of the weapon.
     * @return A string describing the action.
     */
    String fire();

    /**
     * Provides a full description of the weapon and its attachments.
     * @return The complete weapon description string.
     */
    String getDescription();

    /**
     * Calculates and returns the total damage of the weapon.
     * @return The damage value as a double.
     */
    double getDamage();

    /**
     * Calculates and returns the total accuracy of the weapon.
     * @return The accuracy value as a double.
     */
    double getAccuracy();
}