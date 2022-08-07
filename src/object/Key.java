package object;

import java.awt.*;

import static utility.Constant.ObjectConstant.KEY_NAME;

public class Key extends GameObject {
    private final float worldX;
    private final float worldY;
    private int hitboxDefaultX=0, hitboxDefaultY=0;

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
}
