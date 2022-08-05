package object;

import java.awt.image.BufferedImage;

public class GameObject {
    protected BufferedImage image;
    protected String object_name;
    protected boolean collision;
    protected float worldX, worldY;
    protected int objectType;

    public GameObject(float worldX, float worldY, int objectType) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.objectType = objectType;
    }

    public String getObject_name() {
        return object_name;
    }

    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean isCollision() {
        return collision;
    }

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }

    public int getObjectType() {
        return objectType;
    }
}
