package utilities;

import static utilities.Constants.ScreenConstants.TILE_SIZE;

public class Constants {
    /**
     * Screen Settings
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

    /**
     * Directions
     **/
    public static class Directions {
        public static final String UP = "UP";
        public static final String LEFT = "LEFT";
        public static final String DOWN = "DOWN";
        public static final String RIGHT = "RIGHT";
    }

    /**
     * World Settings
     **/
    public static class WorldConstants {
        public static final int MAX_WORLD_COL = 50;
        public static final int MAX_WORLD_ROW = 50;

        public static final int WORLD_WIDTH = TILE_SIZE * MAX_WORLD_COL;      // 2400 pixels
        public static final int WORLD_HEIGHT = TILE_SIZE * MAX_WORLD_ROW;     // 2400 pixels
    }

    /**
     * Object Names
     **/
    public static class ObjectNames {
        public static final String KEY = "KEY";
        public static final String DOOR = "DOOR";
        public static final String CHEST = "CHEST";
    }
}
