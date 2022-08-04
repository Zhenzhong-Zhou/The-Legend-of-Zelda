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
        tiles.add(GRASS = new Tile(GetSpriteAtlas(GRASS_IMAGE), false));
        tiles.add(WATER = new Tile(GetSpriteAtlas(WATER_IMAGE), true));
        tiles.add(WALL = new Tile(GetSpriteAtlas(WALL_IMAGE), true));
        tiles.add(EARTH = new Tile(GetSpriteAtlas(EARTH_IMAGE), false));
        tiles.add(TREE = new Tile(GetSpriteAtlas(TREE_IMAGE), true));
        tiles.add(ROAD = new Tile(GetSpriteAtlas(ROAD_IMAGE), false));
    }

    public BufferedImage getTile(int id) {
        return tiles.get(id).getSprite();
    }

    public Tile getGRASS() {
        return GRASS;
    }

    public Tile getWATER() {
        return WATER;
    }

    public Tile getWALL() {
        return WALL;
    }

    public Tile getEARTH() {
        return EARTH;
    }

    public Tile getTREE() {
        return TREE;
    }

    public Tile getROAD() {
        return ROAD;
    }
}
