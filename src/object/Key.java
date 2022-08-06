package object;

import java.awt.*;

import static utility.Constant.ObjectConstant.KEY_NAME;

public class Key extends GameObject {
    private final float worldX;
    private final float worldY;
    private Rectangle hitbox;
    private

    public Key(float worldX, float worldY, int objectType, Rectangle hitbox) {
        super(worldX, worldY, objectType);
        this.worldX = worldX;
        this.worldY = worldY;
        this.hitbox = hitbox;
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
}
