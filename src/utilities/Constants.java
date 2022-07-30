package utilities;

public class Constants {
    /**
     *  Screen Settings
     **/
    public static class ScreenConstants {
        // Raw Size
        public static final int ORIGINAL_TILE_SIZE = 16;      // 16*16 tile
        public static final int SCALE = 3;
        // Actual Size
        public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;     // 48*48 tile
        // Screen Ratio 4:3
        public static final int MAX_SCREEN_COL = 20;
        public static final int MAX_SCREEN_ROW = 15;
        public static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;      // 960 pixels
        public static final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;     // 720 pixels
    }
}
