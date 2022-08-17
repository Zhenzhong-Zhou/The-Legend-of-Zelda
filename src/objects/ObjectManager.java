package objects;

import entities.Player;
import states.Play;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilities.Constant.SceneConstant.TILE_SIZE;

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
