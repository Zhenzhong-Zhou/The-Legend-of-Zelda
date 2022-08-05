package manager;

import entity.Player;
import object.Door;
import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utility.Constant.SceneConstant.TILE_SIZE;
import static utility.LoadSave.*;

public class ObjectManager {
    private Player player;
    private BufferedImage keyImages, doorImages;
    private ArrayList<Key> keys;
    private ArrayList<Door> doors;

    public ObjectManager(Player player) {
        this.player = player;
        loadObjects();
        loadImages();
        objectSetter();
    }

    private void loadObjects() {
        keys = new ArrayList<>();
        doors = new ArrayList<>();
    }

    private void loadImages() {
        keyImages = GetSpriteAtlas(KEY_IMAGE);
        doorImages = GetSpriteAtlas(DOOR_IMAGE);
    }

    private void objectSetter() {
        addKeys();
        addDoors();
    }

    private void addKeys() {
        keys.add(new Key(55 * TILE_SIZE, 55*TILE_SIZE, 0));
        keys.add(new Key(56 * TILE_SIZE, 56*TILE_SIZE, 0));
    }

    private void addDoors() {
        doors.add(new Door(60 * TILE_SIZE, 55*TILE_SIZE,1));
        doors.add(new Door(55 * TILE_SIZE, 60*TILE_SIZE,1));
    }

    public void update() {

    }

    public void draw(Graphics2D graphics2D) {
        drawKeys(graphics2D);
        drawDoors(graphics2D);
    }

    private void drawKeys(Graphics2D graphics2D) {
        for(Key key : keys) {
            // TODO: Player can be removed
            float worldX = key.getWorldX();
            float worldY = key.getWorldY();
            float screenX = worldX - player.getWorldX() + player.getScreenX();
            float screenY = worldY - player.getWorldY() + player.getScreenY();

            float left = player.getWorldX() -  player.getScreenX();
            float right = player.getWorldX() + player.getScreenX();
            float up = player.getWorldY() - player.getScreenY();
            float down = player.getWorldY() + player.getScreenY();

            if(worldX + TILE_SIZE > left && worldX - TILE_SIZE < right && worldY + TILE_SIZE > up && worldY - TILE_SIZE < down) {
                graphics2D.drawImage(keyImages, (int)screenX, (int)screenY, TILE_SIZE,TILE_SIZE, null);
            }
        }
    }

    private void drawDoors(Graphics2D graphics2D) {
        for(Door door : doors) {
            // TODO: Player can be removed
            float worldX = door.getWorldX();
            float worldY = door.getWorldY();
            float screenX = worldX - player.getWorldX() + player.getScreenX();
            float screenY = worldY - player.getWorldY() + player.getScreenY();

            float left = player.getWorldX() -  player.getScreenX();
            float right = player.getWorldX() + player.getScreenX();
            float up = player.getWorldY() - player.getScreenY();
            float down = player.getWorldY() + player.getScreenY();

            if(worldX + TILE_SIZE > left && worldX - TILE_SIZE < right && worldY + TILE_SIZE > up && worldY - TILE_SIZE < down) {
                graphics2D.drawImage(doorImages, (int)screenX, (int)screenY, TILE_SIZE,TILE_SIZE, null);
            }
        }
    }
}
