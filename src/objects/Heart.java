package objects;

import java.awt.image.BufferedImage;

import static utilities.LoadSave.*;

public class Heart {
    private final BufferedImage heart_full, heart_half, heart_blank;

    public Heart() {
        this.heart_full = GetSpriteAtlas(HEART_FULL);
        this.heart_half = GetSpriteAtlas(HEART_HALF);
        this.heart_blank = GetSpriteAtlas(HEART_BLANK);
    }

    public BufferedImage getHeart_full() {
        return heart_full;
    }

    public BufferedImage getHeart_half() {
        return heart_half;
    }

    public BufferedImage getHeart_blank() {
        return heart_blank;
    }
}
