package utility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

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
        File levelFile = new File("res/" + filename + ".txt");
        try {
            if(! levelFile.createNewFile()) {
                System.out.println("File: " + filename + " is already exists.");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        WriteToFile(levelFile, idArray);
    }

    private static void WriteToFile(File file, int[][] idArray) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for(int[] ints : idArray) {
                for(int anInt : ints) {
                    printWriter.print(anInt + " ");
                }
                printWriter.append("\n");
            }
            printWriter.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int[][] ReadFromFile(File file) {
        int[][] matrix = new int[50][50];
        try {
            Scanner scanner = new Scanner(file);
            int col = 0;
            int row = 0;
            while(col < 50 && row < 50) {
                String line = scanner.nextLine();
                while(col < 50) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    matrix[col][row] = num;
                    col++;
                }
                if(col == 50) {
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
