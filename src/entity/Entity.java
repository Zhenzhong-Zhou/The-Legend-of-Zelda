package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    protected int worldX, worldY, speed;
    protected int width, height;
    protected BufferedImage up1, up2, left1, left2, down1, down2, right1, right2;
    // TODO: once have pathfinding may cause problem because of String not Integer
    protected String direction;
    protected int spriteCounter = 0;
    protected int spriteNum = 1;
    protected int animationSpeed = 50;
    public Rectangle hitbox;
    protected int hitboxDefaultX, hitboxDefaultY;
    protected boolean collision;

    public Entity(int worldX, int worldY, int speed, int width, int height) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public String getDirection() {
        return direction;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public int getSpeed() {
        return speed;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public int getHitboxDefaultX() {
        return hitboxDefaultX;
    }

    public int getHitboxDefaultY() {
        return hitboxDefaultY;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
}
