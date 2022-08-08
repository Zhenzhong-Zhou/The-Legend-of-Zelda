package entities;

import states.Play;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilities.Constant.DirectionConstant.*;
import static utilities.Constant.SceneConstant.*;
import static utilities.Constant.WorldConstant.MAX_WORLD_COL;
import static utilities.Constant.WorldConstant.MAX_WORLD_ROW;
import static utilities.LoadSave.*;

public class Player extends Entity {
    private final float screenX, screenY;
    private final Play play;
    private boolean up, left, down, right;

    public Player(float worldX, float worldY, float speed, int width, int height, Play play) {
        super(worldX, worldY, speed, width, height);
        this.play = play;
        screenX = (int) (SCENE_WIDTH / 2f) - (TILE_SIZE / 2f);
        screenY = (int) (SCENE_HEIGHT / 2f) - (TILE_SIZE / 2f);
//        hitbox = new Rectangle(7, 15, 32, 32);
//        hitboxDefaultX = hitbox.x;
//        hitboxDefaultY = hitbox.y;
//        initClasses();
        setDefaultValues();
        getPlayerImage();
    }

    private void initClasses() {

    }

    private void setDefaultValues() {
        worldX = (MAX_WORLD_COL / 2.0f - 1) * TILE_SIZE;
        worldY = (MAX_WORLD_ROW / 2.0f - 1) * TILE_SIZE;
        speed = 0.9f * SCALE;//TODO: need to change later
        direction = DOWN;
    }

    private void getPlayerImage() {
        up1 = GetSpriteAtlas(UP_1_IMAGE);
        up2 = GetSpriteAtlas(UP_2_IMAGE);
        left1 = GetSpriteAtlas(LEFT_1_IMAGE);
        left2 = GetSpriteAtlas(LEFT_2_IMAGE);
        down1 = GetSpriteAtlas(DOWN_1_IMAGE);
        down2 = GetSpriteAtlas(DOWN_2_IMAGE);
        right1 = GetSpriteAtlas(RIGHT_1_IMAGE);
        right2 = GetSpriteAtlas(RIGHT_2_IMAGE);
    }

    public void update() {
        updatePositions();
        updateAnimation();
    }

    public void updatePositions() {
        if(! left && ! right && ! up && ! down) return;

        if(up) direction = UP;
        if(left) direction = LEFT;
        if(down) direction = DOWN;
        if(right) direction = RIGHT;

        // CHECK TILE COLLISION
        collision = false;
//        collisionDetection.checkTile(this);

        // CHECK OBJECT COLLISION
//        int objectIndex = collisionDetection.checkObject(this, true);
//        collectObject(objectIndex);

        // IF COLLISION IS FALSE, PLAYER CAN MOVE
//        if(! collision) {
        switch(direction) {
            case UP -> worldY -= speed;
            case LEFT -> worldX -= speed;
            case DOWN -> worldY += speed;
            case RIGHT -> worldX += speed;
        }
//        }
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

    public void draw(Graphics2D graphics2D) {
        BufferedImage image = null;

        switch(direction) {
            case UP -> {
                if(spriteNum == 1) {
                    image = up1;
                }
                if(spriteNum == 2) {
                    image = up2;
                }
            }
            case LEFT -> {
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
            }
            case DOWN -> {
                if(spriteNum == 1) {
                    image = down1;
                }
                if(spriteNum == 2) {
                    image = down2;
                }
            }
            case RIGHT -> {
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
            }
            default -> {
            }
        }
        graphics2D.drawImage(image, (int) screenX, (int) screenY, null);
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public float getScreenX() {
        return screenX;
    }

    public float getScreenY() {
        return screenY;
    }
}
