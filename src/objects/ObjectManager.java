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
        screen.objects[0] = new Object_Key();
        screen.objects[0].worldX = 27 * TILE_SIZE;
        screen.objects[0].worldY = 8 * TILE_SIZE;

        screen.objects[1] = new Object_Key();
        screen.objects[1].worldX = 27 * TILE_SIZE;
        screen.objects[1].worldY = 40 * TILE_SIZE;
    }

    public void draw(Graphics2D graphics2D) {
        for(int i =0; i< screen.objects.length; i++) {
            if(screen.objects[i] != null) {
                screen.objects[i].draw(graphics2D, screen);
            }
        }
    }
}
