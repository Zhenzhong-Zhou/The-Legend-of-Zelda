package entities;

import states.Play;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilities.Constant.DirectionConstant.*;
import static utilities.Constant.DirectionConstant.RIGHT;
import static utilities.Constant.SceneConstant.SCALE;
import static utilities.Constant.SceneConstant.TILE_SIZE;
import static utilities.Constant.WorldConstant.MAX_WORLD_COL;
import static utilities.Constant.WorldConstant.MAX_WORLD_ROW;

public class Entity {
    protected Play play;
    protected int worldX, worldY;
    protected float speed;
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
    private boolean up, left, down, right;
    protected int actionLockCounter = 0;

    public Entity(Play play) {
        this.play = play;
        hitbox = new Rectangle(0,0,TILE_SIZE, TILE_SIZE);
        setDefaultValues();
    }

    private void setDefaultValues() {
        speed = 0.1f;
        direction = DOWN;
    }

    public void setAction() {

    }

    public void update() {
        setAction();

        collision = false;
        play.getCollisionDetection().checkTile(this);

        // IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(! collision) {
            switch(direction) {
                case UP -> worldY -= speed;
                case LEFT -> worldX -= speed;
                case DOWN -> worldY += speed;
                case RIGHT -> worldX += speed;
            }
        }
        updateAnimation();
    }

    public void updateAnimation() {
        spriteCounter++;
        if(spriteCounter >= animationSpeed) {
            if(spriteNum == 1) {
                spriteNum = 2;
            } else if(spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
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

    public float getSpeed() {
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
