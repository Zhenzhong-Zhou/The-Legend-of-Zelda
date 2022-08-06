package level;

import static utility.LevelBuilder.getLevelData;

public class Level {
    private final int[][] level;

    public Level() {
        level = getLevelData();
    }
}
