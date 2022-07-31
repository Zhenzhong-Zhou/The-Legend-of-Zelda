package entities;

import java.awt.image.BufferedImage;

public class Entity {
    protected int x, y, speed;
    protected String direction;
    protected BufferedImage up1, up2, left1, left2, down1, down2, right1, right2;
    protected int spriteCounter = 0;
    protected int spriteNum = 1;

    public Entity(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
}
