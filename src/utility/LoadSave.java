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
                    if(x<idArray.length-1) {
                        printWriter.print(idArray[x][y] + " ");
                    }
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
            String line = " ";
            int row = 0;
            while(scanner.hasNextLine()) {
                String[] cols = line.split(" ");
                int col = 0 ;
                for(String colum : cols) {
                    matrix[row][col] = Integer.parseInt(colum);
                    col++;
                }
                row++;
//                data.add(Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return matrix;
    }

//    public static int[][] GetLevelData(String filename) {
//        File levelFile = new File("res/" + filename + ".txt");
//        if(levelFile.exists()) {
//            int[][] data = ReadFromFile(levelFile);
//            return ArrayListTo2Dint(data, 50, 50);
//        } else {
//            System.out.println("File: " + filename + " does not exists!");
//            return null;
//        }
//    }
    public static int[][] GetLevelData(String filename) {
        File levelFile = new File("res/" + filename + ".txt");
        int[][] matrix = new int[50][50];
        try {
            BufferedReader file = new BufferedReader(new FileReader(levelFile));
//            String line = "";
//            int row = 0;
//            while((line = file.readLine()) != null) {
//                String[] cols = line.split(" "); //note that if you have used space as separator you have to split on " "
//                int col = 0;
//                for(String s : cols) {
//                    int data = Integer.parseInt(s);
////                    matrix[row][col] = Integer.parseInt(c);
//                    matrix[row][col] = data;
//                    col++;
//                }
//                row++;
//            }
            int col =0;
            int row =0;
            while(col< 50 && row<50) {
                String line = file.readLine();
                while(col<50) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    matrix[col][row] = num;
                    col++;
                }
                if(col==50) {
                    col = 0;
                    row++;
                }
            }
            file.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return matrix;
    }
}
