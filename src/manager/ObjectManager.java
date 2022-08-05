package manager;

import object.Door;
import object.Key;
import state.Play;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utility.Constant.SceneConstant.TILE_SIZE;
import static utility.LoadSave.*;

public class ObjectManager {
    private Play play;
    private BufferedImage keyImages, doorImages;
    private ArrayList<Key> keys;
    private ArrayList<Door> doors;

    public ObjectManager(Play play) {
        this.play = play;
        keys = new ArrayList<>();
        doors = new ArrayList<>();
        loadImages();
        keys.add(new Key(55 * TILE_SIZE, 55*TILE_SIZE, 0));
        keys.add(new Key(56 * TILE_SIZE, 56*TILE_SIZE, 0));
    }

    private void loadImages() {
        keyImages = GetSpriteAtlas(KEY_IMAGE);
        doorImages = GetSpriteAtlas(DOOR_IMAGE);
    }

    public void update() {

    }

    public void draw(Graphics2D graphics2D) {
        float playerWorldX = play.getPlayer().getWorldX();
        float playerWorldY = play.getPlayer().getWorldY();
        float playerScreenX = play.getPlayer().getScreenX();
        float playerScreenY = play.getPlayer().getScreenY();

        float worldX = keys.get(0).getWorldX();
        float worldY = keys.get(0).getWorldY();
        float screenX = worldX - playerWorldX + playerScreenX;
        float screenY = worldY - playerWorldY + playerScreenY;

        float left = playerWorldX -  playerScreenX;
        float right = playerWorldX + playerScreenX;
        float up = playerWorldY - playerScreenY;
        float down = playerWorldY + playerScreenY;

        if(worldX + TILE_SIZE > left && worldX - TILE_SIZE < right && worldY + TILE_SIZE > up && worldY - TILE_SIZE < down) {
            graphics2D.drawImage(keyImages, (int)screenX, (int)screenY, TILE_SIZE,TILE_SIZE, null);
        }

    }

    private void drawKeys(Graphics2D graphics2D) {
        for(Key key : keys) {
            graphics2D.drawImage(keyImages,(int) key.getWorldX(), (int) key.getWorldY(), TILE_SIZE,TILE_SIZE, null);
        }
    }
}
