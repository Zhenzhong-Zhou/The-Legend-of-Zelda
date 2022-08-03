package entity;

import java.awt.image.BufferedImage;

public abstract class Entity {
    protected float x, y, speed;
    protected int width, height;
    protected BufferedImage up1, up2, left1, left2, down1, down2, right1, right2;
    // TODO: once have pathfinding may cause problem because of String not Integer
    protected String direction;

    public Entity(float x, float y, float speed, int width, int height) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }
}
