package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    protected int worldX, worldY, speed;
    protected String direction;
    protected BufferedImage up1, up2, left1, left2, down1, down2, right1, right2;
    protected int spriteCounter = 0;
    protected int spriteNum = 1;
    protected Rectangle hitbox;
    protected boolean collision = false;

    public Entity(int worldX, int worldY, int speed) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.speed = speed;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public String getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
}
