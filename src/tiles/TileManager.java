package tiles;

import main.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import static utilities.Constants.ScreenConstants.TILE_SIZE;

public class TileManager {
    private Screen screen;
    private Tile[] tile;

    public TileManager(Screen screen) {
        this.screen = screen;
        tile = new Tile[10];
        importTileImage();
    }

    private void importTileImage() {
        try {
            // Grass
            System.out.println("Image loading started" );
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tiles/grass01.png")));
            System.out.println("Image loading started" + tile[0].image);
            // Wall
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tiles/wall.png")));

            // Water
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tiles/water01.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(tile[0].image, 0,0,TILE_SIZE,TILE_SIZE, null);
    }
}
