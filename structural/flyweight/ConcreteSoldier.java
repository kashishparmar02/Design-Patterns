package structural.flyweight;

public class ConcreteSoldier implements Soldier {
    // Intrinsic State: Shared among all soldier objects of this type.
    private final String model3D;
    private final String texture;

    public ConcreteSoldier() {
        // Simulate a very expensive, one-time operation.
        System.out.println("CREATING HEAVY SOLDIER OBJECT: Loading 3D model and textures...");
        this.model3D = "RiflemanModel.obj";
        this.texture = "rifleman_texture.png";
        try {
            Thread.sleep(2000); // Simulate heavy lifting
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("HEAVY SOLDIER OBJECT CREATED.");
    }

    @Override
    public void render(int x, int y, int currentHealth) {
        // The render method uses the shared intrinsic state and the unique extrinsic state.
        System.out.printf(
            "Rendering soldier with model '%s' at (%d, %d) with %d HP.%n",
            model3D, x, y, currentHealth
        );
    }
    
}
