package entities;

import states.Play;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilities.Constant.DirectionConstant.*;
import static utilities.Constant.SceneConstant.TILE_SIZE;

public abstract class Entity {
    protected Play play;
    protected int worldX, worldY;
    protected float speed;
    protected BufferedImage up1, up2, left1, left2, down1, down2, right1, right2;
    protected String direction;
    protected int spriteCounter = 0;
    protected int spriteNum = 1;
    protected int animationSpeed = 50;
    protected Rectangle hitbox;
    protected int hitboxDefaultX, hitboxDefaultY;
    protected boolean collision;
    protected int actionLockCounter = 0;
    protected String[] dialogues = new String[20];
    protected int dialogueIndex = 0;
    protected int maxLives, life;

    public Entity(Play play) {
        this.play = play;
        hitbox = new Rectangle(0,0,TILE_SIZE, TILE_SIZE);
        setDefaultValues();
    }

    private void setDefaultValues() {
        speed = 0.1f;
        direction = DOWN;
    }

    public void setAction() {}

    public void speak() {
        if(dialogues[dialogueIndex] == null) {
            dialogueIndex = 0;
        } else {
            play.getGui().setCurrentDialogue(dialogues[dialogueIndex]);
            dialogueIndex++;
        }
        switch(play.getPlayer().direction) {
            case UP -> direction = DOWN;
            case LEFT -> direction = RIGHT;
            case DOWN -> direction = UP;
            case RIGHT -> direction = LEFT;
        }
    }

    public void update() {
        setAction();

        collision = false;
        play.getCollisionDetection().checkTile(this);
        play.getCollisionDetection().checkObject(this, false);
        play.getCollisionDetection().checkPlayer(this);

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

    public String[] getDialogues() {
        return dialogues;
    }

    public int getMaxLives() {
        return maxLives;
    }

    public void setMaxLives(int maxLives) {
        this.maxLives = maxLives;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
