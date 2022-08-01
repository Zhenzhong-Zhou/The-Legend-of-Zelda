package collisions;

import entities.Entity;
import main.Screen;

import static utilities.Constants.Directions.*;
import static utilities.Constants.ScreenConstants.ORIGINAL_TILE_SIZE;
import static utilities.Constants.ScreenConstants.TILE_SIZE;

public class CollisionDetection {
    private Screen screen;

    public CollisionDetection(Screen screen) {
        this.screen = screen;
    }

    public void detectTile(Entity entity) {
        int entityLeftWorldX = entity.getWorldX() + entity.getHitbox().x;
        int entityRightWorldX = entity.getWorldX() + entity.getHitbox().x + entity.getHitbox().width;
        int entityTopWorldY = entity.getWorldY() + entity.getHitbox().y;
        int entityBottomWorldY = entity.getWorldY() + entity.getHitbox().y + entity.getHitbox().height;

        int entityLeftCol = entityLeftWorldX / TILE_SIZE;
        int entityRightCol = entityRightWorldX / TILE_SIZE;
        int entityTopRow = entityTopWorldY / TILE_SIZE;
        int entityBottomRow = entityBottomWorldY / TILE_SIZE;

        int tileNum1, tileNum2;

        switch(entity.getDirection()) {
            case UP -> {
                entityTopRow = (entityTopWorldY - entity.getSpeed()) / TILE_SIZE;
                tileNum1 = screen.getTileManager().getLevelTileNum()[entityLeftCol][entityTopRow];
                tileNum2 = screen.getTileManager().getLevelTileNum()[entityRightCol][entityTopRow];
                if(screen.getTileManager().getTile()[tileNum1].isCollision() || screen.getTileManager().getTile()[tileNum2].isCollision()) {
                    entity.setCollision(true);
                }
            }
            case LEFT -> {
                entityLeftCol = (entityLeftWorldX - entity.getSpeed()) / TILE_SIZE;
                tileNum1 = screen.getTileManager().getLevelTileNum()[entityLeftCol][entityTopRow];
                tileNum2 = screen.getTileManager().getLevelTileNum()[entityLeftCol][entityBottomRow];
                if(screen.getTileManager().getTile()[tileNum1].isCollision() || screen.getTileManager().getTile()[tileNum2].isCollision()) {
                    entity.setCollision(true);
                }
            }
            case DOWN -> {
                entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / TILE_SIZE;
                tileNum1 = screen.getTileManager().getLevelTileNum()[entityLeftCol][entityBottomRow];
                tileNum2 = screen.getTileManager().getLevelTileNum()[entityRightCol][entityBottomRow];
                if(screen.getTileManager().getTile()[tileNum1].isCollision() || screen.getTileManager().getTile()[tileNum2].isCollision()) {
                    entity.setCollision(true);
                }
            }
            case RIGHT -> {
                entityRightCol = (entityRightWorldX + entity.getSpeed()) / TILE_SIZE;
                tileNum1 = screen.getTileManager().getLevelTileNum()[entityRightCol][entityTopRow];
                tileNum2 = screen.getTileManager().getLevelTileNum()[entityRightCol][entityBottomRow];
                if(screen.getTileManager().getTile()[tileNum1].isCollision() || screen.getTileManager().getTile()[tileNum2].isCollision()) {
                    entity.setCollision(true);
                }
            }
            default -> {}
        }
    }
}
