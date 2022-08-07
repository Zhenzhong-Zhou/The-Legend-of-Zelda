package object;

import java.awt.*;

import static utility.Constant.ObjectConstant.KEY_NAME;
import static utility.Constant.SceneConstant.TILE_SIZE;

public class Key extends GameObject {
    private final int hitboxDefaultX = 0;
    private final int hitboxDefaultY = 0;
    private String object_name;

    public Key(float worldX, float worldY, int objectType) {
        super(worldX, worldY, objectType);
        this.worldX = worldX;
        this.worldY = worldY;
        object_name = KEY_NAME;
        hitbox.x = 23 * TILE_SIZE;
        hitbox.y = 22 * TILE_SIZE;
    }

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }

    @Override
    public Rectangle getHitbox() {
        return hitbox;
    }

    public int getHitboxDefaultX() {
        return hitboxDefaultX;
    }

    public int getHitboxDefaultY() {
        return hitboxDefaultY;
    }

    @Override
    public String getObject_name() {
        return object_name;
    }
}
