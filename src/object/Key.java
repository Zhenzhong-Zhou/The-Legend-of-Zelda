package object;

import static utility.Constant.ObjectConstant.KEY_NAME;
import static utility.Constant.SceneConstant.TILE_SIZE;

public class Key extends GameObject {
    public Key(int worldX, int worldY, int objectType) {
        super(worldX, worldY, objectType);
        object_name = KEY_NAME;
//        initHitbox();
        hitbox.x = 23 * TILE_SIZE;
        hitbox.y = 22 * TILE_SIZE;
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
