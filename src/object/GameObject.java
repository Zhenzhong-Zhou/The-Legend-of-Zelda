package object;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static utility.Constant.SceneConstant.TILE_SIZE;

public class GameObject {
    protected String object_name;
    protected boolean collision;
    protected int worldX, worldY, objectType;
    protected Rectangle2D.Float hitbox;
    protected int hitboxDefaultX = 0, hitboxDefaultY = 0;

    public GameObject(int worldX, int worldY, int objectType) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.objectType = objectType;
    }

    protected void initHitbox() {
        // TODO: (0,0,48,48)
        hitbox = new Rectangle2D.Float(worldX, worldY, TILE_SIZE, TILE_SIZE);
    }

    public void drawHitbox(Graphics2D graphics2D) {
        graphics2D.setColor(Color.PINK);
        graphics2D.drawRect((int) hitbox.x, (int) hitbox.y, TILE_SIZE, TILE_SIZE);
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

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    public int getHitboxDefaultX() {
        return hitboxDefaultX;
    }

    public int getHitboxDefaultY() {
        return hitboxDefaultY;
    }
}
