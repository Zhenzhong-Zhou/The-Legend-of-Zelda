package manager;

import entity.Player;
import object.Chest;
import object.Door;
import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utility.Constant.ObjectConstant.*;
import static utility.Constant.SceneConstant.TILE_SIZE;
import static utility.LoadSave.*;

public class ObjectManager {
    private Player player;
    private BufferedImage keyImage, doorImage, chestImage;
    private ArrayList<Key> keys;
    private ArrayList<Door> doors;
    private ArrayList<Chest> chests;

    public ObjectManager(Player player) {
        this.player = player;
        loadObjects();
        loadImages();
        objectSetter();
    }

    private void loadObjects() {
        keys = new ArrayList<>();
        doors = new ArrayList<>();
        chests = new ArrayList<>();
    }

    private void loadImages() {
        keyImage = GetSpriteAtlas(KEY_IMAGE);
        doorImage = GetSpriteAtlas(DOOR_IMAGE);
        chestImage = GetSpriteAtlas(CHEST_IMAGE);
    }

    private void objectSetter() {
        addKeys();
        addDoors();
        addChests();
    }

    private void addKeys() {
        keys.add(new Key(55 * TILE_SIZE, 55*TILE_SIZE, KEY_TYPE));
        keys.add(new Key(56 * TILE_SIZE, 56*TILE_SIZE, KEY_TYPE));
    }

    private void addDoors() {
        doors.add(new Door(60 * TILE_SIZE, 55*TILE_SIZE, DOOR_TYPE));
        doors.add(new Door(55 * TILE_SIZE, 60*TILE_SIZE, DOOR_TYPE));
    }

    private void addChests() {
        chests.add(new Chest(65 * TILE_SIZE, 65*TILE_SIZE, CHEST_TYPE));
        chests.add(new Chest(70 * TILE_SIZE, 70*TILE_SIZE, CHEST_TYPE));
    }

    public void update() {

    }

    public void draw(Graphics2D graphics2D) {
        drawKeys(graphics2D);
        drawDoors(graphics2D);
        drawChests(graphics2D);
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
                graphics2D.drawImage(keyImage, (int)screenX, (int)screenY, TILE_SIZE,TILE_SIZE, null);
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
                graphics2D.drawImage(doorImage, (int)screenX, (int)screenY, TILE_SIZE,TILE_SIZE, null);
            }
        }
    }

    private void drawChests(Graphics2D graphics2D) {
        for(Chest chest : chests) {
            // TODO: Player can be removed
            float worldX = chest.getWorldX();
            float worldY = chest.getWorldY();
            float screenX = worldX - player.getWorldX() + player.getScreenX();
            float screenY = worldY - player.getWorldY() + player.getScreenY();

            float left = player.getWorldX() -  player.getScreenX();
            float right = player.getWorldX() + player.getScreenX();
            float up = player.getWorldY() - player.getScreenY();
            float down = player.getWorldY() + player.getScreenY();

            if(worldX + TILE_SIZE > left && worldX - TILE_SIZE < right && worldY + TILE_SIZE > up && worldY - TILE_SIZE < down) {
                graphics2D.drawImage(chestImage, (int)screenX, (int)screenY, TILE_SIZE,TILE_SIZE, null);
            }
        }
    }
}
