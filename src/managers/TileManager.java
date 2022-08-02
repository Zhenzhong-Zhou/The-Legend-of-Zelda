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
    public Tile GRASS, WATER, WALL;
    public ArrayList<Tile> tiles = new ArrayList<>();
//    public Tile[] tile;

    public TileManager() {
//        tile = new Tile[10];
        createTiles();
//        getTileSprite();
    }

    private void createTiles() {
        tiles.add(GRASS = new Tile(GetSpriteAtlas(GRASS_IMAGE)));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_IMAGE)));
        tiles.add(WALL = new Tile(GetSpriteAtlas(WALL_IMAGE)));
    }

    public BufferedImage getTile(int id) {
        return tiles.get(id).getSprite();
    }

//    private void getTileSprite() {
//        // Grass
//        tile[0] = new Tile();
//        tile[0].image = GetSpriteAtlas(GRASS);
//
//        // Wall
//        tile[1] = new Tile();
//        tile[1].image = GetSpriteAtlas(WALL);
//
//        // Water
//        tile[2] = new Tile();
//        tile[2].image = GetSpriteAtlas(WATER);
//    }


    public void draw(Graphics2D graphics2D) {
//        graphics2D.drawImage(tile[0].image,0,0, TILE_SIZE, TILE_SIZE, null);
        graphics2D.drawImage(getTile(0),0,0, TILE_SIZE, TILE_SIZE, null);
    }
}
