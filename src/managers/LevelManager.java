package managers;

import main.Game;

import java.awt.*;

import static utility.Constant.SceneConstant.TILE_SIZE;
import static utility.LevelBuilder.getLevelData;

public class LevelManager {
    private Game game;
    private int[][] level;
    private TileManager tileManager;

    public LevelManager(Game game) {
        this.game = game;
        level = getLevelData();
        tileManager = new TileManager();
    }

    public void draw(Graphics2D graphics2D) {
        for(int x = 0; x <level.length; x++) {
            for(int y = 0; y<level[x].length; y++) {
                int id = level[x][y];
                graphics2D.drawImage(tileManager.getTile(id), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE,null);
            }
        }
    }
}
