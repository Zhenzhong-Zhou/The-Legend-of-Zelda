package manager;

import main.Game;

import java.awt.*;

import static utility.Constant.SceneConstant.TILE_SIZE;
import static utility.LevelBuilder.getLevelData;
import static utility.LoadSave.*;

public class LevelManager {
    private final Game game;
    private final TileManager tileManager;
    private int[][] level;

    public LevelManager(Game game) {
        this.game = game;
        level = getLevelData();
        tileManager = new TileManager();
        createDefaultLevel();
        loadDefaultLevel();
        saveLevel();
    }

    private void createDefaultLevel() {
        int cols = 50;
        int rows = 50;
        int[][] array = new int[cols][rows];

        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                array[i][j] = 0;
            }
        }
        CreateLevel("default_level", array);
    }

    public void saveLevel() {
        SaveLevel("default_level", level);
    }

    private void loadDefaultLevel() {
        level = GetLevelData("default_level");
    }

    public void draw(Graphics2D graphics2D) {
        for(int x = 0; x < level.length; x++) {
            for(int y = 0; y < level[x].length; y++) {
                int id = level[x][y];
                graphics2D.drawImage(tileManager.getTile(id), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
            }
        }
    }
}
