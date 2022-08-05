package object;

public class Key extends GameObject{
    private float worldX, worldY;

    public Key(float worldX, float worldY, int objectType) {
        super(worldX, worldY, objectType);
        this.worldX = worldX;
        this.worldY = worldY;
        object_name = "Key";
    }

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }
}
