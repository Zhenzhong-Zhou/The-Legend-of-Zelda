package entities;

import main.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static utilities.Constants.Directions.*;
import static utilities.Constants.ScreenConstants.*;

public class Player extends Entity {
    private boolean up, left, down, right;
    private final int screenX, screenY;
    private Screen screen;

    public Player(int x, int y, int speed, Screen screen) {
        super(x, y, speed);
        this.screen = screen;
        screenX = (SCREEN_WIDTH / 2) - (TILE_SIZE/2);
        screenY = (SCREEN_HEIGHT / 2) - (TILE_SIZE/2);
        initHitbox();
        setDefaultValues();
        getPlayerImage();
    }

    private void initHitbox() {
        hitbox = new Rectangle(8,16,32,32);
    }

    public void setDefaultValues() {
        worldX = 23 * TILE_SIZE;
        worldY = 21 * TILE_SIZE;
        speed = 1;
        direction = DOWN;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walk/boy_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walk/boy_up_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walk/boy_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walk/boy_left_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walk/boy_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walk/boy_down_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walk/boy_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walk/boy_right_2.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        updatePosition();
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

        graphics2D.drawImage(image, screenX, screenY, TILE_SIZE, TILE_SIZE, null);
    }

    public void updatePosition() {
        if(left||right||up||down) {
            if(left && ! right) {
                direction = LEFT;
//            worldX -= speed;
            } else if(right && ! left) {
                direction = RIGHT;
//            worldX += speed;
            }

            if(up && ! down) {
                direction = UP;
//            worldY -= speed;
            } else if(down && ! up) {
                direction = DOWN;
//            worldY += speed;
            }

            // Check Tile Collision
            collision = false;
            screen.getCollisionDetection().detectTile(this);

            if(! collision) {
                switch(direction) {
                    case UP ->  worldY -= speed;
                    case LEFT ->  worldX -= speed;
                    case DOWN -> worldY += speed;
                    case RIGHT -> worldX += speed;
                    default -> {}
                }
            }

            updateAnimations();
        }
    }

    private void updateAnimations() {
        spriteCounter++;
        if(spriteCounter > 20) {
            if(spriteNum == 1) {
                spriteNum = 2;
            } else if(spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
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

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }
}
