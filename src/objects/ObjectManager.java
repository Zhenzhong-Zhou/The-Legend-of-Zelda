package objects;

import main.Screen;

import java.awt.*;

import static utilities.Constants.ScreenConstants.TILE_SIZE;

public class ObjectManager {
    private Screen screen;

    public ObjectManager(Screen screen) {
        this.screen = screen;
    }

    public void setObjects() {
        // Keys
        screen.objects[0] = new Object_Key();
        screen.objects[0].worldX = 27 * TILE_SIZE;
        screen.objects[0].worldY = 8 * TILE_SIZE;

        screen.objects[1] = new Object_Key();
        screen.objects[1].worldX = 27 * TILE_SIZE;
        screen.objects[1].worldY = 40 * TILE_SIZE;

        screen.objects[2] = new Object_Key();
        screen.objects[2].worldX = 42 * TILE_SIZE;
        screen.objects[2].worldY = 11 * TILE_SIZE;

        // Doors
        screen.objects[3] = new Object_Door();
        screen.objects[3].worldX = 14 * TILE_SIZE;
        screen.objects[3].worldY = 12 * TILE_SIZE;

        screen.objects[4] = new Object_Door();
        screen.objects[4].worldX = 12 * TILE_SIZE;
        screen.objects[4].worldY = 29 * TILE_SIZE;

        screen.objects[5] = new Object_Door();
        screen.objects[5].worldX = 16 * TILE_SIZE;
        screen.objects[5].worldY = 22 * TILE_SIZE;

        // Chest
        screen.objects[6] = new Object_Chest();
        screen.objects[6].worldX = 14 * TILE_SIZE;
        screen.objects[6].worldY = 9 * TILE_SIZE;
    }

    public void draw(Graphics2D graphics2D) {
        for(int i =0; i< screen.objects.length; i++) {
            if(screen.objects[i] != null) {
                screen.objects[i].draw(graphics2D, screen);
            }
        }
    }
}
