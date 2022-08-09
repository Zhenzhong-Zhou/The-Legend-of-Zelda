package utilities;

import entities.Entity;
import objects.GameObject;
import states.Play;

import java.util.ArrayList;

import static utilities.Constant.DirectionConstant.*;
import static utilities.Constant.SceneConstant.TILE_SIZE;

public class CollisionDetection {
    private final Play play;

    public CollisionDetection(Play play) {
        this.play = play;
    }

    public void checkTile(Entity entity) {
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
                tileNum1 = play.getLevelManager().getTileId()[entityLeftCol][entityTopRow];
                tileNum2 = play.getLevelManager().getTileId()[entityRightCol][entityTopRow];
                boolean collision1 = play.getLevelManager().getTileManager().getTiles().get(tileNum1).isCollision();
                boolean collision2 = play.getLevelManager().getTileManager().getTiles().get(tileNum2).isCollision();

                if(collision1 || collision2) {
                    entity.setCollision(true);
                }
            }
            case LEFT -> {
                entityLeftCol = (entityLeftWorldX - entity.getSpeed()) / TILE_SIZE;
                tileNum1 = play.getLevelManager().getTileId()[entityLeftCol][entityTopRow];
                tileNum2 = play.getLevelManager().getTileId()[entityLeftCol][entityBottomRow];
                boolean collision1 = play.getLevelManager().getTileManager().getTiles().get(tileNum1).isCollision();
                boolean collision2 = play.getLevelManager().getTileManager().getTiles().get(tileNum2).isCollision();

                if(collision1 || collision2) {
                    entity.setCollision(true);
                }
            }
            case DOWN -> {
                entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / TILE_SIZE;
                tileNum1 = play.getLevelManager().getTileId()[entityLeftCol][entityBottomRow];
                tileNum2 = play.getLevelManager().getTileId()[entityRightCol][entityBottomRow];
                boolean collision1 = play.getLevelManager().getTileManager().getTiles().get(tileNum1).isCollision();
                boolean collision2 = play.getLevelManager().getTileManager().getTiles().get(tileNum2).isCollision();

                if(collision1 || collision2) {
                    entity.setCollision(true);
                }
            }
            case RIGHT -> {
                entityRightCol = (entityRightWorldX + entity.getSpeed()) / TILE_SIZE;
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

        ArrayList<GameObject> objects = play.getObjectManager().getObjects();
        for(int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object != null) {
                // Get entity's hitbox position
                entity.getHitbox().x = entity.getWorldX() + entity.getHitbox().x;
                entity.getHitbox().y = entity.getWorldY() + entity.getHitbox().y;

                // Get the object's hitbox position
                object.getHitbox().x = object.getWorldX() + object.getHitbox().x;
                object.getHitbox().y = object.getWorldY() + object.getHitbox().y;

                switch(entity.getDirection()) {
                    case UP -> {
                        entity.getHitbox().y -= entity.getSpeed();
                        if(entity.getHitbox().intersects(object.getHitbox())) {
                            if(object.isCollision()) {
                                entity.setCollision(true);
                            }
                            if(player) {
                                index = i;
                            }
                        }
                    }
                    case LEFT -> {
                        entity.getHitbox().x += entity.getSpeed();
                        if(entity.getHitbox().intersects(object.getHitbox())) {
                            if(object.isCollision()) {
                                entity.setCollision(true);
                            }
                            if(player) {
                                index = i;
                            }
                        }
                    }
                    case DOWN -> {
                        entity.getHitbox().y += entity.getSpeed();
                        if(entity.getHitbox().intersects(object.getHitbox())) {
                            if(object.isCollision()) {
                                entity.setCollision(true);
                            }
                            if(player) {
                                index = i;
                            }
                        }
                    }
                    case RIGHT -> {
                        entity.getHitbox().x -= entity.getSpeed();
                        if(entity.getHitbox().intersects(object.getHitbox())) {
                            if(object.isCollision()) {
                                entity.setCollision(true);
                            }
                            if(player) {
                                index = i;
                            }
                        }
                    }
                    default -> {
                    }
                }
                entity.getHitbox().x = entity.getHitboxDefaultX();
                entity.getHitbox().y = entity.getHitboxDefaultY();
                object.getHitbox().x = object.getHitboxDefaultX();
                object.getHitbox().y = object.getHitboxDefaultY();
            }
        }
        return index;
    }
}
