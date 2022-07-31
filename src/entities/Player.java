package entities;

import main.Screen;

import java.awt.*;

import static utilities.Constants.ScreenConstants.TILE_SIZE;

public class Player extends Entity{
    private Screen screen;
    private boolean up, left, down, right;

    public Player(int x, int y, int speed) {
        super(x, y, speed);
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {
        updatePosition();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect(x, y, TILE_SIZE,TILE_SIZE);
    }

    public void updatePosition() {
        if (left && !right) {
            x -= speed;
        } else if (right && !left) {
            x += speed;
        }

        if (up && !down) {
            y -= speed;
        } else if (down && !up) {
            y += speed;
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
}
