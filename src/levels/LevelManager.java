package levels;

import entities.Player;
import main.Scene;
import tiles.TileManager;

import java.awt.*;

import static utilities.Constant.SceneConstant.*;
import static utilities.Constant.WorldConstant.*;
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
        CreateLevel(array);
    }

    public void saveLevel() {
        SaveLevel(level);
    }

    private void loadDefaultLevel() {
        level = GetLevelData();
    }

    public void draw(Graphics2D graphics2D, Player player) {
        // TODO: may remove player
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < MAX_WORLD_COL && worldRow < MAX_WORLD_ROW) {
            int id = level[worldCol][worldRow];

            int worldX = worldCol * TILE_SIZE;
            int worldY = worldRow * TILE_SIZE;
            int playerWorldX = player.getWorldX();
            int playerWorldY = player.getWorldY();
            int playerScreenX = player.getScreenX();
            int playerScreenY = player.getScreenY();

            int screenX = worldX - playerWorldX + playerScreenX;
            int screenY = worldY - playerWorldY + playerScreenY;

            int left = playerWorldX - playerScreenX;
            int right = playerWorldX + playerScreenX;
            int up = playerWorldY - playerScreenY;
            int down = playerWorldY + playerScreenY;

            // Stop moving the camera at the edge of map
            if(playerScreenX > playerWorldX) {
                screenX = worldX;
            }
            if(playerScreenY > playerWorldY) {
                screenY = worldY;
            }

            int rightOffset = SCENE_WIDTH - playerScreenX;
            if(rightOffset > WORLD_WIDTH - playerWorldX) {
                screenX = SCENE_WIDTH - (WORLD_WIDTH - worldX);
            }

            int bottomOffset = SCENE_HEIGHT - playerScreenY;
            if(bottomOffset > WORLD_HEIGHT - playerWorldY) {
                screenY = SCENE_HEIGHT - (WORLD_HEIGHT - worldY);
            }

            if(worldX + TILE_SIZE > left && worldX - TILE_SIZE < right && worldY + TILE_SIZE > up && worldY - TILE_SIZE < down) {
                graphics2D.drawImage(tileManager.getSprite(id), screenX, screenY, null);
            } else if(playerScreenX > playerWorldX ||
                    playerScreenY > playerWorldY ||
                    rightOffset > WORLD_WIDTH - playerWorldX ||
                    bottomOffset > WORLD_HEIGHT - playerWorldY) {
                graphics2D.drawImage(tileManager.getSprite(id), screenX, screenY, null);
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
