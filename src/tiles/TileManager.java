package tiles;

import main.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

import static utilities.Constants.ScreenConstants.*;
import static utilities.Constants.WorldConstants.MAX_WORLD_COL;
import static utilities.Constants.WorldConstants.MAX_WORLD_ROW;

public class TileManager {
    private final Screen screen;
    private final Tile[] tile;
    private int levelTileNum[][];

    public TileManager(Screen screen) {
        this.screen = screen;
        tile = new Tile[10];
        levelTileNum = new int[MAX_WORLD_COL][MAX_WORLD_ROW];
        importTileImage();
        loadMap("map/world01.txt");
    }

    private void importTileImage() {
        try {
            // Grass
            System.out.println("Image loading started");
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass01.png")));
            System.out.println("Image loading started" + tile[0].image);
            // Wall
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall.png")));

            // Water
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water01.png")));

            // Earth
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/earth.png")));

            // Tree
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/tree.png")));

            // Road
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road00.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMap(String filepath) {
        try {
            InputStream is = getClass().getResourceAsStream("/" + filepath);
            assert is != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while(col < MAX_WORLD_COL && row <MAX_WORLD_ROW) {
                String line = reader.readLine();
                while(col < MAX_WORLD_COL) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    levelTileNum[col][row] = num;
                    col++;
                }
                if(col == MAX_WORLD_COL) {
                    col = 0;
                    row++;
                }
            }
            reader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < MAX_WORLD_COL && worldRow < MAX_WORLD_ROW) {
            int tileNum = levelTileNum[worldCol][worldRow];

            int worldX = worldCol * TILE_SIZE;
            int worldY = worldRow * TILE_SIZE;
            int screenX = worldX - screen.getGame().getPlayer().getWorldX() + screen.getGame().getPlayer().getScreenX();
            int screenY = worldY - screen.getGame().getPlayer().getWorldY() + screen.getGame().getPlayer().getScreenY();

            graphics2D.drawImage(tile[tileNum].image, screenX,screenY,TILE_SIZE, TILE_SIZE, null);
            worldCol++;

            if(worldCol == MAX_WORLD_COL) {
                worldCol =0 ;
                worldRow++;
            }
        }
    }
}
