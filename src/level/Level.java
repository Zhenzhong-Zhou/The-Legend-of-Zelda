package level;

import static utility.LevelBuilder.getLevelData;

public class Level {
    private int[][] level;

    public Level() {
        level = getLevelData();
    }
}
