package object;

import static utility.Constant.ObjectConstant.KEY_NAME;

public class Key extends GameObject {
    private final float worldX;
    private final float worldY;

    public Key(float worldX, float worldY, int objectType) {
        super(worldX, worldY, objectType);
        this.worldX = worldX;
        this.worldY = worldY;
        object_name = KEY_NAME;
    }

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }
}
