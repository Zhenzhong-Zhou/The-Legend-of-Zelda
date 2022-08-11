package objects;

import java.awt.image.BufferedImage;

import static utilities.Constant.ObjectConstant.BOOT_NAME;
import static utilities.LoadSave.*;

public class Boot extends GameObject{
    private final BufferedImage sprite;
    private final int worldX;
    private final int worldY;
    private final int objectType;
    private final String objectName;
    private final boolean collision;

    public Boot(BufferedImage sprite, int worldX, int worldY, int objectType, String objectName, boolean collision) {
        super(sprite, worldX, worldY, objectType, objectName, collision);
        this.sprite = sprite;
        this.worldX = worldX;
        this.worldY = worldY;
        this.objectType = objectType;
        this.objectName = objectName;
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
