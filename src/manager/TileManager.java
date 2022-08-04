package manager;

import tile.Tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utility.LoadSave.*;

public class TileManager {
    public Tile GRASS, WATER, WALL, EARTH, TREE, ROAD;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager() {
        createTiles();
    }

    private void createTiles() {
        tiles.add(GRASS = new Tile(GetSpriteAtlas(GRASS_IMAGE)));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_IMAGE)));
        tiles.add(WALL = new Tile(GetSpriteAtlas(WALL_IMAGE)));
        tiles.add(EARTH = new Tile(GetSpriteAtlas(EARTH_IMAGE)));
        tiles.add(TREE = new Tile(GetSpriteAtlas(TREE_IMAGE)));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_IMAGE)));
    }

    public BufferedImage getTile(int id) {
        return tiles.get(id).getSprite();
    }
}
