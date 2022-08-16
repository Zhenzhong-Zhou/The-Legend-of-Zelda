package entities;

import states.Play;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    protected Play play;
    protected int worldX, worldY, speed;
    protected int width, height;
    protected BufferedImage up1, up2, left1, left2, down1, down2, right1, right2;
    // TODO: once have pathfinding may cause problem because of String not Integer
    protected String direction;
    protected int spriteCounter = 0;
    protected int spriteNum = 1;
    protected int animationSpeed = 50;
    protected Rectangle hitbox;
    protected int hitboxDefaultX, hitboxDefaultY;
    protected boolean collision;

    public Entity(Play play) {
        this.play = play;
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

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
}
