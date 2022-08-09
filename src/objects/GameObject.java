package objects;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilities.Constant.SceneConstant.TILE_SIZE;

public class GameObject {
    private BufferedImage sprite;
    protected String object_name;
    protected boolean collision;
    protected int worldX, worldY, objectType;
    protected Rectangle hitbox;
    protected int hitboxDefaultX = 0, hitboxDefaultY = 0;

    public GameObject(BufferedImage sprite, int worldX, int worldY, int objectType) {
        this.sprite = sprite;
        this.worldX = worldX;
        this.worldY = worldY;
        this.objectType = objectType;
        hitbox = new Rectangle(0, 0, TILE_SIZE, TILE_SIZE);
    }

    public String getObject_name() {
        return object_name;
    }

    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public int getObjectType() {
        return objectType;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public int getHitboxDefaultX() {
        return hitboxDefaultX;
    }

    public int getHitboxDefaultY() {
        return hitboxDefaultY;
    }
}
