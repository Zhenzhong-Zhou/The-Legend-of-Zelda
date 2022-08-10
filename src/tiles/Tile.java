package tiles;

import java.awt.image.BufferedImage;

public class Tile {
    private final BufferedImage sprite;
    private String tileName;
    private int tileId;
    private final boolean collision;

    public Tile(BufferedImage sprite, String tileName, int tileId, boolean collision) {
        this.sprite = sprite;
        this.tileName = tileName;
        this.tileId = tileId;
        this.collision = collision;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public String getTileName() {
        return tileName;
    }

    public int getTileId() {
        return tileId;
    }

    public boolean isCollision() {
        return collision;
    }
}
