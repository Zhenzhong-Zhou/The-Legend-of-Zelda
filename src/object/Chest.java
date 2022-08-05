package object;

import static utility.Constant.ObjectConstant.CHEST_NAME;

public class Chest extends GameObject{
    private float worldX, worldY;

    public Chest(float worldX, float worldY, int objectType) {
        super(worldX, worldY, objectType);
        this.worldX = worldX;
        this.worldY = worldY;
        object_name = CHEST_NAME;
    }

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }
}
