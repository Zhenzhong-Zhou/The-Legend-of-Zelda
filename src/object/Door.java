package object;

import static utility.Constant.ObjectConstant.DOOR_NAME;

public class Door extends GameObject {
    private final float worldX;
    private final float worldY;

    public Door(float worldX, float worldY, int objectType) {
        super(worldX, worldY, objectType);
        this.worldX = worldX;
        this.worldY = worldY;
        object_name = DOOR_NAME;
    }

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }
}
