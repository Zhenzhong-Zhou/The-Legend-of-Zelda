package objects;

import entities.Player;
import states.Play;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilities.Constant.ObjectConstant.*;
import static utilities.Constant.SceneConstant.TILE_SIZE;
import static utilities.LoadSave.*;

public class ObjectManager {
    private final Play play;
    private ArrayList<GameObject> objects;
    private GameObject KEY, DOOR, CHEST;
    private Key key;
    private Door door;
    private Chest chest;

    public ObjectManager(Play play) {
        this.play = play;
        loadObjects();
        objectSetter();
    }

    private void loadObjects() {
        objects = new ArrayList<>();
    }

    private void objectSetter() {
        // KEY 1
        objects.add(new Key(GetSpriteAtlas(KEY_IMAGE), 23 * TILE_SIZE, 22 * TILE_SIZE, KEY_TYPE, KEY_NAME, false));
        // KEY 2
        objects.add(new Key(GetSpriteAtlas(KEY_IMAGE), 25 * TILE_SIZE, 73 * TILE_SIZE, KEY_TYPE, KEY_NAME, false));

        // DOOR 1
        objects.add(new Door(GetSpriteAtlas(DOOR_IMAGE), 84 * TILE_SIZE, 85 * TILE_SIZE, DOOR_TYPE, DOOR_NAME, true));
        // DOOR 2
        objects.add(new Door(GetSpriteAtlas(DOOR_IMAGE), 44 * TILE_SIZE, 14 * TILE_SIZE, DOOR_TYPE, DOOR_NAME, true));
        // FINAL DOOR
        objects.add(new Door(GetSpriteAtlas(DOOR_IMAGE), 75 * TILE_SIZE, 28 * TILE_SIZE, DOOR_TYPE, DOOR_NAME, true));

        // CHEST 1
        objects.add(new Chest(GetSpriteAtlas(CHEST_IMAGE), 82 * TILE_SIZE, 83 * TILE_SIZE, CHEST_TYPE, CHEST_NAME, false));
        // FINAL CHEST
        objects.add(new Chest(GetSpriteAtlas(CHEST_IMAGE), 75 * TILE_SIZE, 19 * TILE_SIZE, CHEST_TYPE, CHEST_NAME, false));
    }

    public void update() {

    }

    public void draw(Graphics2D graphics2D, Player player) {
        for(GameObject object : objects) {
            // TODO: Player can be removed
            int worldX = object.getWorldX();
            int worldY = object.getWorldY();
            int screenX = worldX - player.getWorldX() + player.getScreenX();
            int screenY = worldY - player.getWorldY() + player.getScreenY();

            int left = player.getWorldX() - player.getScreenX();
            int right = player.getWorldX() + player.getScreenX();
            int up = player.getWorldY() - player.getScreenY();
            int down = player.getWorldY() + player.getScreenY();

            if(worldX + TILE_SIZE > left && worldX - TILE_SIZE < right && worldY + TILE_SIZE > up && worldY - TILE_SIZE < down) {
                graphics2D.drawImage(object.sprite, screenX, screenY, null);
            }
        }
    }

    public BufferedImage getObject(int id) {
        return objects.get(id).getSprite();
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }
}
