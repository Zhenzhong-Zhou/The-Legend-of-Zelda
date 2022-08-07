package object;

import static utility.Constant.ObjectConstant.DOOR_NAME;

public class Door extends GameObject {
    private float worldX, worldY;

    public Door(float worldX, float worldY, int objectType) {
        super(worldX, worldY, objectType);
        this.worldX = worldX;
        this.worldY = worldY;
        object_name = DOOR_NAME;
//        collision = true;
//        initHitbox();
//        hitboxDefaultX = worldX;
//        hitboxDefaultY = worldY;
        collision = true;
    }

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }
}
