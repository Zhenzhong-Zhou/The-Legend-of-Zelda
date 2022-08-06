package collision;

import entity.Entity;
import state.Play;

import static utility.Constant.DirectionConstant.*;
import static utility.Constant.SceneConstant.TILE_SIZE;

public class CollisionDetection {
    private Play play;
    public CollisionDetection(Play play) {
        this.play = play;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = (int) (entity.getWorldX() + entity.getHitbox().x);
        int entityRightWorldX = (int) (entity.getWorldX() + entity.getHitbox().x + entity.getHitbox().width);
        int entityTopWorldY = (int) (entity.getWorldY() + entity.getHitbox().y);
        int entityBottomWorldY = (int) (entity.getWorldY() + entity.getHitbox().y + entity.getHitbox().height);

        int entityLeftCol = entityLeftWorldX/ TILE_SIZE;
        int entityRightCol = entityRightWorldX/ TILE_SIZE;
        int entityTopRow = entityTopWorldY/ TILE_SIZE;
        int entityBottomRow = entityBottomWorldY/ TILE_SIZE;

        int tileNum1, tileNum2;
        switch(entity.getDirection()) {
            case UP -> {
                entityTopRow = (int) ((entityTopWorldY - entity.getSpeed()) / TILE_SIZE);
                tileNum1 = play.getLevelManager().getTileId()[entityLeftCol][entityTopRow];
                tileNum2 = play.getLevelManager().getTileId()[entityRightCol][entityTopRow];
                boolean collision1 = play.getLevelManager().getTileManager().getTiles().get(tileNum1).isCollision();
                boolean collision2 = play.getLevelManager().getTileManager().getTiles().get(tileNum2).isCollision();

                if(collision1 || collision2) {
                    entity.setCollision(true);
                }
            }
            case LEFT -> {
                entityLeftCol = (int) ((entityLeftWorldX - entity.getSpeed()) / TILE_SIZE);
                tileNum1 = play.getLevelManager().getTileId()[entityLeftCol][entityTopRow];
                tileNum2 = play.getLevelManager().getTileId()[entityLeftCol][entityBottomRow];
                boolean collision1 = play.getLevelManager().getTileManager().getTiles().get(tileNum1).isCollision();
                boolean collision2 = play.getLevelManager().getTileManager().getTiles().get(tileNum2).isCollision();

                if(collision1 || collision2) {
                    entity.setCollision(true);
                }
            }
            case DOWN -> {
                entityBottomRow = (int) ((entityBottomWorldY + entity.getSpeed()) / TILE_SIZE);
                tileNum1 = play.getLevelManager().getTileId()[entityLeftCol][entityBottomRow];
                tileNum2 = play.getLevelManager().getTileId()[entityRightCol][entityBottomRow];
                boolean collision1 = play.getLevelManager().getTileManager().getTiles().get(tileNum1).isCollision();
                boolean collision2 = play.getLevelManager().getTileManager().getTiles().get(tileNum2).isCollision();

                if(collision1 || collision2) {
                    entity.setCollision(true);
                }
            }
            case RIGHT -> {
                entityRightCol = (int) ((entityRightWorldX + entity.getSpeed()) / TILE_SIZE);
                tileNum1 = play.getLevelManager().getTileId()[entityRightCol][entityTopRow];
                tileNum2 = play.getLevelManager().getTileId()[entityRightCol][entityBottomRow];
                boolean collision1 = play.getLevelManager().getTileManager().getTiles().get(tileNum1).isCollision();
                boolean collision2 = play.getLevelManager().getTileManager().getTiles().get(tileNum2).isCollision();

                if(collision1 || collision2) {
                    entity.setCollision(true);
                }
            }
            default -> {}
        }
    }
}
