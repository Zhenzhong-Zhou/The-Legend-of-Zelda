package utility;

public class Constant {
    /**
     * GAME SETTINGS
     */
    public static class GameConstant {
        public static final int FPS_SET = 120;
        public static final int UPS_SET = 200;
    }

    /**
     * SCENE SETTINGS
     */
    public static class SceneConstant {
        public static final int ORIGINAL_TILES_SIZE = 16;       // 16*16 tile
        public static final float SCALE = 3f;

        /*
            Actual Size
         */
        public static final int TILE_SIZE = (int) (ORIGINAL_TILES_SIZE * SCALE);    // 48*48 tile
        // @formatter:off
        public static final int MAX_SCREEN_COL = 20;        // ratio 4:3
        public static final int MAX_SCREEN_ROW = 15;        // ratio 4:3
        // @formatter:on
        public static final int SCENE_WIDTH = TILE_SIZE * MAX_SCREEN_COL;       // 768 pixels
        public static final int SCENE_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;      // 576 pixels
    }
}
