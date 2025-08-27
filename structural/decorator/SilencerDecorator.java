package structural.decorator;

public class SilencerDecorator extends WeaponAttachmentDecorator {
    public SilencerDecorator(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }
    
    @Override
    public String fire() {
        return "Firing with a silenced shot.";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Silencer";
    }

    @Override
    public double getDamage() {
        // Silencers often slightly reduce damage/range in games.
        return super.getDamage() - 3.0;
    }
}