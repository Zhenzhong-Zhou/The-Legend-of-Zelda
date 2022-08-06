package object;

import static utility.Constant.ObjectConstant.CHEST_NAME;

public class Chest extends GameObject {
    public Chest(int worldX, int worldY, int objectType) {
        super(worldX, worldY, objectType);
        object_name = CHEST_NAME;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }
}
