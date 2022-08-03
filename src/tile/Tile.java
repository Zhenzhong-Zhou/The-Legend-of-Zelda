package tile;

import java.awt.image.BufferedImage;

public class Tile {
    private final BufferedImage sprite;
    private final boolean collision = false;

    public Tile(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public BufferedImage getSprite() {
        return sprite;
    }
}
