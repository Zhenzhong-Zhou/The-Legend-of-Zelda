package object;

import java.awt.*;

import static utility.Constant.SceneConstant.TILE_SIZE;

public class GameObject {
    protected String object_name;
    protected boolean collision;
    protected float worldX, worldY;
    protected int objectType;
    protected Rectangle hitbox;
    protected int hitboxDefaultX = 0, hitboxDefaultY = 0;

    public GameObject(float worldX, float worldY, int objectType) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.objectType = objectType;
        hitbox = new Rectangle(0, 0, TILE_SIZE, TILE_SIZE);
    }

//    protected void initHitbox() {
//        // TODO: (0,0,48,48)
//        hitbox = new Rectangle2D.Float(worldX, worldY, TILE_SIZE, TILE_SIZE);
//    }
//
//    public void drawHitbox(Graphics2D graphics2D) {
//        graphics2D.setColor(Color.PINK);
//        graphics2D.drawRect((int) hitbox.x, (int) hitbox.y, TILE_SIZE, TILE_SIZE);
//    }

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

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }

    public int getObjectType() {
        return objectType;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

//    public int getHitboxDefaultX() {
//        return hitboxDefaultX;
//    }
//
//    public int getHitboxDefaultY() {
//        return hitboxDefaultY;
//    }
}
