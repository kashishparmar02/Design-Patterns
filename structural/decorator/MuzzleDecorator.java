package structural.decorator;

public class MuzzleDecorator extends WeaponAttachmentDecorator {
    public MuzzleDecorator(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Muzzle Brake";
    }

    @Override
    public double getDamage() {
        // Muzzle increases damage.
        return super.getDamage() + 5.0;
    }

    @Override
    public double getAccuracy() {
        // But slightly reduces accuracy due to recoil pattern change.
        return super.getAccuracy() - 2.0;
    }
}