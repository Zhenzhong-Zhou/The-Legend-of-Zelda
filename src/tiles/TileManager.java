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

public class TileManager {
    private final Screen screen;
    private final Tile[] tile;
    private int levelTileNum[][];

    public TileManager(Screen screen) {
        this.screen = screen;
        tile = new Tile[10];
        levelTileNum = new int[MAX_SCREEN_COL][MAX_SCREEN_ROW];
        importTileImage();
        loadMap("map/level01.txt");
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
            while(col < MAX_SCREEN_COL && row <MAX_SCREEN_ROW) {
                String line = reader.readLine();
                while(col < MAX_SCREEN_COL) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    levelTileNum[col][row] = num;
                    col++;
                }
                if(col == MAX_SCREEN_COL) {
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
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0 ;

        while(col < MAX_SCREEN_COL && row < MAX_SCREEN_ROW) {
            int tileNum = levelTileNum[col][row];
            graphics2D.drawImage(tile[tileNum].image, x,y,TILE_SIZE, TILE_SIZE, null);
            col++;
            x+=TILE_SIZE;
            if(col == MAX_SCREEN_COL) {
                col =0 ;
                x=0;
                row++;
                y+=TILE_SIZE;
            }
        }
    }
}
