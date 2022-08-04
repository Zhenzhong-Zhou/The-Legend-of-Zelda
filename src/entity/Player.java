package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utility.Constant.DirectionConstant.*;
import static utility.Constant.SceneConstant.*;
import static utility.Constant.WorldConstant.*;
import static utility.LoadSave.*;

public class Player extends Entity {
    private boolean up, left, down, right;
    private final float screenX, screenY;

    public Player(float worldX, float worldY, float speed, int width, int height) {
        super(worldX, worldY, speed, width, height);
        screenX = (int) (SCENE_WIDTH / 2f) - (TILE_SIZE / 2f);
        screenY = (int) (SCENE_HEIGHT / 2f) - (TILE_SIZE / 2f);
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = (MAX_WORLD_COL/2.0f-1) * TILE_SIZE;
        worldY = (MAX_WORLD_ROW/2.0f-1) * TILE_SIZE;
        speed = 2f * SCALE;
        direction = DOWN;
    }

    public void getPlayerImage() {
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

        if(left) {
            direction = LEFT;
            worldX -= speed;
        }
        if(right) {
            direction = RIGHT;
            worldX += speed;
        }

        if(up) {
            direction = UP;
            worldY -= speed;
        }
        if(down) {
            direction = DOWN;
            worldY += speed;
        }
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
        graphics2D.drawImage(image, (int) screenX, (int) screenY, TILE_SIZE, TILE_SIZE, null);
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
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
