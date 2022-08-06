package collision;

import entity.Entity;
import object.Chest;
import object.Door;
import object.Key;
import state.Play;

import java.util.ArrayList;

import static utility.Constant.DirectionConstant.*;
import static utility.Constant.SceneConstant.TILE_SIZE;

public class CollisionDetection {
    private final Play play;

    public CollisionDetection(Play play) {
        this.play = play;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = (int) (entity.getWorldX() + entity.getHitbox().x);
        int entityRightWorldX = (int) (entity.getWorldX() + entity.getHitbox().x + entity.getHitbox().width);
        int entityTopWorldY = (int) (entity.getWorldY() + entity.getHitbox().y);
        int entityBottomWorldY = (int) (entity.getWorldY() + entity.getHitbox().y + entity.getHitbox().height);

        int entityLeftCol = entityLeftWorldX / TILE_SIZE;
        int entityRightCol = entityRightWorldX / TILE_SIZE;
        int entityTopRow = entityTopWorldY / TILE_SIZE;
        int entityBottomRow = entityBottomWorldY / TILE_SIZE;

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
            default -> {
            }
        }
    }

    public int checkObject(Entity entity, boolean player) {
        int index = 999;
        int objectSize = play.getPlayer().getObjectManager().getObjectSize();
        ArrayList<Key> keys = play.getPlayer().getObjectManager().getKeys();
        ArrayList<Door> doors = play.getPlayer().getObjectManager().getDoors();
        ArrayList<Chest> chests = play.getPlayer().getObjectManager().getChests();

        for(int i =0;i< objectSize;i++) {
            if(keys.get(i) != null && doors.get(i) != null && chests.get(i) != null) {
                // Get entity's hitbox position
                entity.getHitbox().x = (int) (entity.getWorldX() + entity.getHitbox().x);
                entity.getHitbox().y = (int) (entity.getWorldY() + entity.getHitbox().y);

                // Get the object's hitbox position
                keys.get(i).getHitbox().x = (int) (keys.get(i).getWorldX() + keys.get(i).getHitbox().x);
                keys.get(i).getHitbox().y = (int) (keys.get(i).getWorldY() + keys.get(i).getHitbox().y);

                switch(entity.getDirection()) {
                    case UP -> {
                        entity.getHitbox().y -= entity.getSpeed();
                        if(entity.getHitbox().intersects(keys.get(i).getHitbox())) {
                            System.out.println("UP collision!");
                        }
                    }
                    case LEFT -> {
                        entity.getHitbox().x += entity.getSpeed();
                        if(entity.getHitbox().intersects(keys.get(i).getHitbox())) {
                            System.out.println("LEFT collision!");
                        }
                    }
                    case DOWN -> {
                        entity.getHitbox().y += entity.getSpeed();
                        if(entity.getHitbox().intersects(keys.get(i).getHitbox())) {
                            System.out.println("DOWN collision!");
                        }
                    }
                    case RIGHT -> {
                        entity.getHitbox().x -= entity.getSpeed();
                        if(entity.getHitbox().intersects(keys.get(i).getHitbox())) {
                            System.out.println("RIGHT collision!");
                        }
                    }
                    default -> {
                    }
                }
                entity.getHitbox().x = entity.getHitboxDefaultX();
                entity.getHitbox().y = entity.getHitboxDefaultY();
                keys.get(i).getHitbox().x = keys.get(i).getHitbox().getHitboxDefaultX();
            }
        }

        return index;
    }
}
