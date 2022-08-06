package object;

import static utility.Constant.ObjectConstant.DOOR_NAME;

public class Door extends GameObject {
    private int worldX, worldY;

    public Door(int worldX, int worldY, int objectType) {
        super(worldX, worldY, objectType);
        this.worldX = worldX;
        this.worldY = worldY;
        object_name = DOOR_NAME;
//        collision = true;
//        initHitbox();
        hitboxDefaultX = worldX;
        hitboxDefaultY = worldY;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }
}
