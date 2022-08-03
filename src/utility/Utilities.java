package utility;

import java.util.ArrayList;

public class Utilities {
    public static int[][] ArrayListTo2Dint(int[][] data, int xSize, int ySize) {
        int[][] idArray = new int[xSize][ySize];

        for(int i=0; i< idArray.length; i++) {
            for(int j=0; j<idArray[i].length; j++) {
                int index = i*xSize + j;
//                idArray[i][j] = data.get(index);
            }
        }
        return idArray;
    }
}
