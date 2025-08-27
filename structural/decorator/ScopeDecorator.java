package structural.decorator;

public class ScopeDecorator extends WeaponAttachmentDecorator {
    public ScopeDecorator(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with 4x Scope";
    }

    @Override
    public double getAccuracy() {
        // A scope increases accuracy.
        return super.getAccuracy() + 15.0;
    }
}