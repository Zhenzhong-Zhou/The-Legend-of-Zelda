package entity;

import java.awt.image.BufferedImage;

public abstract class Entity {
    protected float worldX, worldY, speed;
    protected int width, height;
    protected BufferedImage up1, up2, left1, left2, down1, down2, right1, right2;
    // TODO: once have pathfinding may cause problem because of String not Integer
    protected String direction;
    protected int spriteCounter = 0;
    protected int spriteNum = 1;
    protected int animationSpeed = 50;

    public Entity(float worldX, float worldY, float speed, int width, int height) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }
}
