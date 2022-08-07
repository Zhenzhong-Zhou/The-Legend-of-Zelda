package utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

import static utilities.Constant.WorldConstant.MAX_WORLD_COL;
import static utilities.Constant.WorldConstant.MAX_WORLD_ROW;

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

    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage image = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
        try {
            assert is != null;
            image = ImageIO.read(is);
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

    public static void CreateLevel(String filename, int[][] idArray) {
        int counter = 10;
        String filePath = "res/";
        String fileType = ".txt";
        File levelFile = new File(filePath + filename + fileType);
        if(levelFile.exists()) {
            System.out.println("File: " + levelFile + " is already exists.");
        } else {
            try {
                levelFile.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }

            WriteToFile(levelFile, idArray);
        }

        String levelName = "level";
        for(int i = 0; i < counter; i++) {
            File newFile = new File(filePath + levelName + i + fileType);
            if(newFile.exists()) {
                System.out.println("File: " + newFile + " is already exists.");
            } else {
                try {
                    newFile.createNewFile();
                } catch(IOException e) {
                    e.printStackTrace();
                }

                WriteToFile(newFile, idArray);
            }
        }
    }

    private static void WriteToFile(File file, int[][] idArray) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
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

    public static void SaveLevel(String filename, int[][] idArray) {
        File levelFile = new File("res/" + filename + ".txt");
        if(levelFile.exists()) {
            WriteToFile(levelFile, idArray);
        } else {
            //TODO: new level
            System.out.println("File: " + filename + " is already exists.");
        }
    }

    private static int[][] ReadFromFile(File file) {
        int[][] matrix = new int[MAX_WORLD_COL][MAX_WORLD_ROW];
        try {
            Scanner scanner = new Scanner(file);
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

    public static int[][] GetLevelData(String filename) {
        File levelFile = new File("res/" + filename + ".txt");
        if(levelFile.exists()) {
            return ReadFromFile(levelFile);
        } else {
            System.out.println("File: " + filename + " does not exist!");
            return null;
        }
    }
}
