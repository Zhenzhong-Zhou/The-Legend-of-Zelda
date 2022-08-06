package object;

import static utility.Constant.ObjectConstant.KEY_NAME;

public class Key extends GameObject {
    public Key(int worldX, int worldY, int objectType) {
        super(worldX, worldY, objectType);
        object_name = KEY_NAME;
        initHitbox();
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
