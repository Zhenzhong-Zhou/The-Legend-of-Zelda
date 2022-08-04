package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utility.Constant.DirectionConstant.*;
import static utility.Constant.SceneConstant.*;
import static utility.LoadSave.*;

public class Player extends Entity {
    private boolean up, left, down, right;

    public Player(float x, float y, float speed, int width, int height) {
        super(x, y, speed, width, height);
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = (int) (SCENE_WIDTH / 2f);
        y = (int) (SCENE_HEIGHT / 2f);
        speed = 0.3f * SCALE;
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
            x -= speed;
        }
        if(right) {
            direction = RIGHT;
            x += speed;
        }

        if(up) {
            direction = UP;
            y -= speed;
        }
        if(down) {
            direction = DOWN;
            y += speed;
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
        graphics2D.drawImage(image, (int) x, (int) y, TILE_SIZE, TILE_SIZE, null);
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
}
