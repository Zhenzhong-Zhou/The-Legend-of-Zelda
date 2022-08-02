package managers;

import main.Game;
import tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static utility.Constant.SceneConstant.TILE_SIZE;
import static utility.LoadSave.*;

public class TileManager {
    private Game game;
//    public Tile GRASS;
//    public BufferedImage atlas;
//    public ArrayList<Tile> tiles = new ArrayList<>();
    public Tile[] tile;

    public TileManager(Game game) {
        this.game = game;
        tile = new Tile[10];
        createTiles();
        loadAtlas();
        getTileSprite();
    }

    private void createTiles() {
//        try {
//            tiles.add(GRASS = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass01.png"))));
//        }catch(IOException e) {
//            e.printStackTrace();
//        }
    }

    private void loadAtlas() {

    }

    private void getTileSprite() {
        // Grass
        tile[0] = new Tile();
        tile[0].image = GetSpriteAtlas(GRASS);

        // Wall
        tile[1] = new Tile();
        tile[1].image = GetSpriteAtlas(WALL);

        // Water
        tile[2] = new Tile();
        tile[2].image = GetSpriteAtlas(WATER);
    }


    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(tile[0].image,0,0, TILE_SIZE, TILE_SIZE, null);
    }
}
