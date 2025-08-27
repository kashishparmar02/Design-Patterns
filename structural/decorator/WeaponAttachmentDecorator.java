package structural.decorator;

/**
 * Abstract Decorator: Serves as the base class for all weapon attachments.
 * It holds a reference to the weapon it wraps and delegates calls to it by default.
 */
public abstract class WeaponAttachmentDecorator implements Weapon {
    protected Weapon decoratedWeapon;

    public WeaponAttachmentDecorator(Weapon decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    @Override
    public String fire() {
        return decoratedWeapon.fire();
    }

    @Override
    public String getDescription() {
        return decoratedWeapon.getDescription();
    }

    @Override
    public double getDamage() {
        return decoratedWeapon.getDamage();
    }

    @Override
    public double getAccuracy() {
        return decoratedWeapon.getAccuracy();
    }
}