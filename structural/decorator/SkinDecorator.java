package structural.decorator;

public class SkinDecorator extends WeaponAttachmentDecorator {
    private String skinName;

    public SkinDecorator(Weapon decoratedWeapon, String skinName) {
        super(decoratedWeapon);
        this.skinName = skinName;
    }

    @Override
    public String getDescription() {
        // Appends the specific skin name to the description.
        return super.getDescription() + ", with '" + this.skinName + "' Skin";
    }
    
    // Note: A skin does not affect fire(), getDamage(), or getAccuracy(),
    // so we don't override them. They will be delegated to the wrapped object.
}