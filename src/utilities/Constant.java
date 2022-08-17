package utilities;

import static utilities.Constant.SceneConstant.SCENE_WIDTH;
import static utilities.Constant.SceneConstant.TILE_SIZE;

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
        public static final int SCENE_WIDTH = MAX_SCREEN_COL * TILE_SIZE;       // 1152 pixels
        public static final int SCENE_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE;      // 864 pixels
        public static final int MAX_SCREEN_COL = 24;        // ratio 4:3
        public static final int MAX_SCREEN_ROW = 18;        // ratio 4:3
    }

    /**
     * DIRECTIONS
     */
    public static class DirectionConstant {
        public static final String UP = "UP";
        public static final String LEFT = "LEFT";
        public static final String DOWN = "DOWN";
        public static final String RIGHT = "RIGHT";
    }

    /**
     * WORLD SETTINGS
     */
    public static class WorldConstant {
        public static final int MAX_WORLD_COL = 100;
        public static final int MAX_WORLD_ROW = 100;
        public static final int WORLD_WIDTH = MAX_WORLD_COL * TILE_SIZE;
        public static final int WORLD_HEIGHT = MAX_WORLD_ROW * TILE_SIZE;
    }

    /**
     * OBJECT SETTINGS
     */
    public static class ObjectConstant {
        // Object Name
        public static final String KEY_NAME = "KEY";
        public static final String DOOR_NAME = "DOOR";
        public static final String CHEST_NAME = "CHEST";
        public static final String BOOT_NAME = "BOOT";

        // Object Types
        public static final int KEY_TYPE = 0;
        public static final int DOOR_TYPE = 1;
        public static final int CHEST_TYPE = 2;
        public static final int BOOT_TYPE = 3;
    }

    /**
     * GUI SETTINGS
     */
    public static class GUI {
        public static class Buttons {
            public static final int Y_OFFSET = 65;
            public static final int BUTTON_WIDTH = 220;
            public static final int BUTTON_HEIGHT = 60;
            public static final int BUTTON_X = SCENE_WIDTH / 2 - BUTTON_WIDTH / 2;
            public static final int BUTTON_Y = 770;
        }
    }

    /**
     * AUDIO SETTINGS
     */
    public static class AudioManager {
        // MUSICS
        public static final int MENU = 0;

        // SOUND EFFECTS
        public static final int COIN = 0;
        public static final int POWER_UP = 1;
        public static final int UNLOCK = 2;
        public static final int FAN_FARE = 3;
    }
}
