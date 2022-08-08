package levels;

import entities.Player;
import main.Scene;
import tiles.TileManager;

import java.awt.*;

import static utilities.Constant.SceneConstant.TILE_SIZE;
import static utilities.Constant.WorldConstant.MAX_WORLD_COL;
import static utilities.Constant.WorldConstant.MAX_WORLD_ROW;
import static utilities.LoadSave.*;

public class LevelManager {
    private final Scene scene;
    private final TileManager tileManager;
    private int[][] level;

    public LevelManager(Scene scene) {
        this.scene = scene;
        tileManager = new TileManager();
        createDefaultLevel();
        loadDefaultLevel();
        saveLevel();
    }

    private void createDefaultLevel() {
        int cols = MAX_WORLD_COL;
        int rows = MAX_WORLD_ROW;
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

    public void draw(Graphics2D graphics2D, Player player) {
        // TODO: may remove player
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < MAX_WORLD_COL && worldRow < MAX_WORLD_ROW) {
            int id = level[worldCol][worldRow];

            float worldX = worldCol * TILE_SIZE;
            float worldY = worldRow * TILE_SIZE;
            float playerWorldX = player.getWorldX();
            float playerWorldY = player.getWorldY();
            float playerScreenX = player.getScreenX();
            float playerScreenY = player.getScreenY();

            float screenX = worldX - playerWorldX + playerScreenX;
            float screenY = worldY - playerWorldY + playerScreenY;

            float left = playerWorldX - playerScreenX;
            float right = playerWorldX + playerScreenX;
            float up = playerWorldY - playerScreenY;
            float down = playerWorldY + playerScreenY;

            if(worldX + TILE_SIZE > left && worldX - TILE_SIZE < right && worldY + TILE_SIZE > up && worldY - TILE_SIZE < down) {
                graphics2D.drawImage(tileManager.getTile(id), (int) screenX, (int) screenY, TILE_SIZE, TILE_SIZE, null);
            }
            worldCol++;

            if(worldCol == MAX_WORLD_COL) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    public int[][] getTileId() {
        return level;
    }

    public TileManager getTileManager() {
        return tileManager;
    }
}
