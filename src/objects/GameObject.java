package objects;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilities.Constant.SceneConstant.TILE_SIZE;

public class GameObject {
    private BufferedImage sprite;
    protected String objectName;
    protected boolean collision;
    protected int worldX, worldY, objectType;
    protected Rectangle hitbox;
    protected int hitboxDefaultX = 0, hitboxDefaultY = 0;

    public GameObject(BufferedImage sprite, int worldX, int worldY, int objectType, String objectName, boolean collision) {
        this.sprite = sprite;
        this.worldX = worldX;
        this.worldY = worldY;
        this.objectType = objectType;
        this.objectName = objectName;
        this.collision = collision;
        hitbox = new Rectangle(0, 0, TILE_SIZE, TILE_SIZE);
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
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
