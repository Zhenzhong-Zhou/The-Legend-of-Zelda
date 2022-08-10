package utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

import static utilities.Constant.SceneConstant.TILE_SIZE;
import static utilities.Constant.WorldConstant.MAX_WORLD_COL;
import static utilities.Constant.WorldConstant.MAX_WORLD_ROW;
import static utilities.Tool.ScaleImage;

public class LoadSave {
    // PLAYER WALK
    public static final String UP_1_IMAGE = "player/walk/boy_up_1.png";
    public static final String UP_2_IMAGE = "player/walk/boy_up_2.png";
    public static final String LEFT_1_IMAGE = "player/walk/boy_left_1.png";
    public static final String LEFT_2_IMAGE = "player/walk/boy_left_2.png";
    public static final String DOWN_1_IMAGE = "player/walk/boy_down_1.png";
    public static final String DOWN_2_IMAGE = "player/walk/boy_down_2.png";
    public static final String RIGHT_1_IMAGE = "player/walk/boy_right_1.png";
    public static final String RIGHT_2_IMAGE = "player/walk/boy_right_2.png";

    // TILES
    public static final String GRASS_IMAGE = "tiles/grass01.png";
    public static final String WALL_IMAGE = "tiles/wall.png";
    public static final String WATER_IMAGE = "tiles/water01.png";
    public static final String EARTH_IMAGE = "tiles/earth.png";
    public static final String TREE_IMAGE = "tiles/tree.png";
    public static final String ROAD_IMAGE = "tiles/road00.png";

    // OBJECTS
    public static final String KEY_IMAGE = "objects/key.png";
    public static final String DOOR_IMAGE = "objects/door.png";
    public static final String CHEST_IMAGE = "objects/chest.png";

    // FONTS
    public static final String MARU_MONICA= "fonts/x12y16pxMaruMonica.ttf";
    public static final String PURISA_BOLD= "fonts/Purisa Bold.ttf";

    // Level File Path Config
    public static String homePath = System.getProperty("user.home");
    public static String saveFolder = "The Legend of Zelda";
    public static String levelFile = "default_level.txt";
    public static String filePath = homePath + File.separator + saveFolder + File.separator + levelFile;
    private static final File dataFile = new File(filePath);

    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage image = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
        try {
            assert is != null;
            image = ImageIO.read(is);
            image = ScaleImage(image, TILE_SIZE, TILE_SIZE);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert is != null;
                is.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }

    public static Font GetFont(String fileName) {
        Font font = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
        try {
            assert is != null;
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch(IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert is != null;
                is.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return font;
    }

    public static void CreatedFolder() {
        File folder = new File(homePath + File.separator + saveFolder);
        if(! folder.exists()) {
            folder.mkdir();
        }
    }

    public static void CreateLevel(int[][] idArray) {
        if(dataFile.exists()) {
            System.out.println("File: " + dataFile + " is already exists.");
        } else {
            try {
                dataFile.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }

            WriteToFile(idArray);
        }
    }

    private static void WriteToFile(int[][] idArray) {
        try {
            PrintWriter printWriter = new PrintWriter(dataFile);
            for(int y = 0; y < idArray.length; y++) {
                for(int x = 0; x < idArray[y].length; x++) {
                    if(x < idArray[y].length) {
                        printWriter.print(idArray[x][y] + "\t");
                    }
                }
                printWriter.append("\n");
            }
            printWriter.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void SaveLevel(int[][] idArray) {
        if(dataFile.exists()) {
            WriteToFile(idArray);
        } else {
            //TODO: new level
            System.out.println("File: " + dataFile + " is already exists.");
        }
    }

    private static int[][] ReadFromFile() {
        int[][] matrix = new int[MAX_WORLD_COL][MAX_WORLD_ROW];
        try {
            Scanner scanner = new Scanner(dataFile);
            int col = 0;
            int row = 0;
            while(col < MAX_WORLD_COL && row < MAX_WORLD_ROW) {
                String line = scanner.nextLine();
                while(col < MAX_WORLD_COL) {
                    String[] numbers = line.split("\t");
                    int num = Integer.parseInt(numbers[col]);
                    matrix[col][row] = num;
                    col++;
                }
                if(col == MAX_WORLD_COL) {
                    col = 0;
                    row++;
                }
            }
            scanner.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    public static int[][] GetLevelData() {
        if(dataFile.exists()) {
            return ReadFromFile();
        } else {
            System.out.println("File: " + dataFile + " does not exist!");
            return null;
        }
    }
}
