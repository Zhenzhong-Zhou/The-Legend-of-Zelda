package entities;

import objects.GameObject;
import states.Play;
import utilities.CollisionDetection;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilities.Constant.DirectionConstant.*;
import static utilities.Constant.ObjectConstant.DOOR_NAME;
import static utilities.Constant.ObjectConstant.KEY_NAME;
import static utilities.Constant.SceneConstant.*;
import static utilities.Constant.WorldConstant.*;
import static utilities.Constant.WorldConstant.WORLD_HEIGHT;
import static utilities.LoadSave.*;

public class Player extends Entity {
    private final float screenX, screenY;
    private final Play play;
    private boolean up, left, down, right;
    private int hasKey = 0;

    public Player(float worldX, float worldY, float speed, int width, int height, Play play) {
        super(worldX, worldY, speed, width, height);
        this.play = play;
        screenX = (int) (SCENE_WIDTH / 2f) - (TILE_SIZE / 2f);
        screenY = (int) (SCENE_HEIGHT / 2f) - (TILE_SIZE / 2f);
        hitbox = new Rectangle(8, 16, 32, 32);
        hitboxDefaultX = hitbox.x;
        hitboxDefaultY = hitbox.y;
        initClasses();
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
        play.getCollisionDetection().checkTile(this);

            // CHECK OBJECT COLLISION
        int objectIndex = play.getCollisionDetection().checkObject(this, true);
        collectObject(objectIndex);

        // IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(! collision) {
            switch(direction) {
                case UP -> worldY -= speed;
                case LEFT -> worldX -= speed;
                case DOWN -> worldY += speed;
                case RIGHT -> worldX += speed;
            }
        }
    }

    public void collectObject(int objectIndex) {
        if(objectIndex != 999) {
            ArrayList<GameObject> objects = play.getObjectManager().getObjects();
            objects.remove(objectIndex);
            String objectName = objects.get(objectIndex).getObjectName();
            System.out.println(objectName + " " + objects.get(objectIndex).isCollision());
            switch(objectName) {
                case KEY_NAME -> {
                    hasKey++;
                    objects.remove(objectIndex);
                    System.out.println("Key: " + hasKey);
                }
                case DOOR_NAME -> {
                    if(hasKey > 0) {
                        objects.remove(objectIndex);
                        hasKey-- ;
                    }
                    System.out.println("Key: " + hasKey);
                }
            }
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

        int x = (int) screenX;
        int y = (int) screenY;
        if(screenX > worldX) {
            x = (int) worldX;
        }
        if(screenY > worldY) {
            y = (int) worldY;
        }

        int rightOffset = (int) (SCENE_WIDTH - screenX);
        if(rightOffset >  WORLD_WIDTH - worldX) {
            x = (int) (SCENE_WIDTH - (WORLD_WIDTH - worldX));
        }

        int bottomOffset = (int) (SCENE_HEIGHT - screenY);
        if(bottomOffset > WORLD_HEIGHT - worldY) {
            y = (int) (SCENE_HEIGHT - (WORLD_HEIGHT - worldY));
        }

        graphics2D.drawImage(image, x, y, null);
        // Draw hitbox
        graphics2D.setColor(Color.RED);
        graphics2D.drawRect(x + 8, y + 16, 32, 32);
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

    public void resetDirectionBoolean() {
        up = false;
        left = false;
        down = false;
        right = false;
    }
}
