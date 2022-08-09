package objects;

import java.awt.image.BufferedImage;

import static utilities.Constant.ObjectConstant.DOOR_NAME;
import static utilities.Constant.ObjectConstant.KEY_NAME;
import static utilities.LoadSave.*;

public class Key extends GameObject{
    private BufferedImage sprite;
    private int worldX, worldY, objectType;
    private String objectName;
    private boolean collision;

    public Key(BufferedImage sprite, int worldX, int worldY, int objectType, String objectName, boolean collision) {
        super(sprite, worldX, worldY, objectType, objectName, collision);
        this.worldX = worldX;
        this.worldY = worldY;
        this.objectType = objectType;
        this.objectName = KEY_NAME;
        this.sprite = GetSpriteAtlas(KEY_IMAGE);
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
