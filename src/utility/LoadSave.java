package utility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static utility.Utilities.ArrayListTo2Dint;

public class LoadSave {
    // TILES
    public static final String GRASS_IMAGE = "tiles/grass01.png";
    public static final String WALL_IMAGE = "tiles/wall.png";
    public static final String WATER_IMAGE = "tiles/water01.png";

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
        if(levelFile.exists()) {
            System.out.println("File: " + filename + " is already exists.");
        } else {
            try {
               levelFile.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        WriteToFile(levelFile, idArray);
    }

    private static void WriteToFile(File file, int[][] idArray) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for(int x = 0; x<idArray.length; x++) {
                for(int y = 0; y<idArray[x].length; y++) {
                    printWriter.print(idArray[x][y] + " ");
                }
            }
            printWriter.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Integer> ReadFromFile(File file) {
        ArrayList<Integer> data = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                data.add(Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static int[][] GetLevelData(String filename) {
        File levelFile = new File("/res" + filename + ".txt");
        if(levelFile.exists()) {
            ArrayList<Integer> data = ReadFromFile(levelFile);
            return ArrayListTo2Dint(data, 50,50);
        } else {
            System.out.println("File: " + filename + " does not exists!");
            return null;
        }
    }
}
