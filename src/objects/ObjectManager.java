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
        objects.add(KEY = new GameObject(GetSpriteAtlas(KEY_IMAGE), 23 * TILE_SIZE, 22 * TILE_SIZE, KEY_TYPE, KEY_NAME, false));
        // KEY 2
        objects.add(KEY = new GameObject(GetSpriteAtlas(KEY_IMAGE),25 * TILE_SIZE, 73 * TILE_SIZE, KEY_TYPE, KEY_NAME, false));

        // DOOR 1
        objects.add(DOOR = new GameObject(GetSpriteAtlas(DOOR_IMAGE), 84 * TILE_SIZE, 85 * TILE_SIZE, DOOR_TYPE, DOOR_NAME, true));
        // DOOR 2
        objects.add(DOOR = new GameObject(GetSpriteAtlas(DOOR_IMAGE), 44 * TILE_SIZE, 14 * TILE_SIZE, DOOR_TYPE, DOOR_NAME, true));
        // FINAL DOOR
        objects.add(DOOR = new GameObject(GetSpriteAtlas(DOOR_IMAGE), 75 * TILE_SIZE, 28 * TILE_SIZE, DOOR_TYPE, DOOR_NAME, true));

        // CHEST 1
        objects.add(CHEST = new GameObject(GetSpriteAtlas(CHEST_IMAGE), 82 * TILE_SIZE, 83 * TILE_SIZE, CHEST_TYPE, CHEST_NAME, false));
        // FINAL CHEST
        objects.add(CHEST = new GameObject(GetSpriteAtlas(CHEST_IMAGE), 75 * TILE_SIZE, 19 * TILE_SIZE, CHEST_TYPE, CHEST_NAME, false));
    }

    public void update() {

    }

    public void draw(Graphics2D graphics2D, Player player) {
        for(int i =0 ; i<objects.size(); i++) {
            // TODO: Player can be removed
            GameObject object = objects.get(i);
            float worldX = objects.get(i).getWorldX();
            float worldY = object.getWorldY();
            float screenX = worldX - player.getWorldX() + player.getScreenX();
            float screenY = worldY - player.getWorldY() + player.getScreenY();

            float left = player.getWorldX() - player.getScreenX();
            float right = player.getWorldX() + player.getScreenX();
            float up = player.getWorldY() - player.getScreenY();
            float down = player.getWorldY() + player.getScreenY();

            if(worldX + TILE_SIZE > left && worldX - TILE_SIZE < right && worldY + TILE_SIZE > up && worldY - TILE_SIZE < down) {
                graphics2D.drawImage(getObject(i), (int) screenX, (int) screenY, null);
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
