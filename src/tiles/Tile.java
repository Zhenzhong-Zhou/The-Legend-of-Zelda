package tiles;

import java.awt.image.BufferedImage;

public class Tile {
    protected BufferedImage image;
    protected boolean collision = false;

    public boolean isCollision() {
        return collision;
    }
}
