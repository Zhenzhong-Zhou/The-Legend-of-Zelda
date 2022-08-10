package objects;

import java.awt.image.BufferedImage;

import static utilities.Constant.ObjectConstant.CHEST_NAME;
import static utilities.LoadSave.CHEST_IMAGE;
import static utilities.LoadSave.GetSpriteAtlas;

public class Chest extends GameObject {
    private final BufferedImage sprite;
    private final int worldX;
    private final int worldY;
    private final int objectType;
    private final String objectName;
    private final boolean collision;

    public Chest(BufferedImage sprite, int worldX, int worldY, int objectType, String objectName, boolean collision) {
        super(sprite, worldX, worldY, objectType, objectName, collision);
        this.worldX = worldX;
        this.worldY = worldY;
        this.objectType = objectType;
        this.objectName = CHEST_NAME;
        this.sprite = GetSpriteAtlas(CHEST_IMAGE);
        this.collision = collision;
    }


    @Override
    public BufferedImage getSprite() {
        return sprite;
    }

    @Override
    public int getWorldX() {
        return worldX;
    }

    @Override
    public int getWorldY() {
        return worldY;
    }

    @Override
    public int getObjectType() {
        return objectType;
    }

    @Override
    public String getObjectName() {
        return objectName;
    }

    @Override
    public boolean isCollision() {
        return collision;
    }
}