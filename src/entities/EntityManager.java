package entities;

import states.Play;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilities.Constant.DirectionConstant.*;
import static utilities.Constant.SceneConstant.TILE_SIZE;
import static utilities.Constant.WorldConstant.MAX_WORLD_COL;
import static utilities.Constant.WorldConstant.MAX_WORLD_ROW;

public class EntityManager {
    private final Play play;
    private Entity[] npcs;

    public EntityManager(Play play) {
        this.play = play;

        loadNPCs();
        npcsSetter();
    }

    private void loadNPCs() {
        npcs = new Entity[10];
    }

    private void npcsSetter() {
        npcs[0] = new NPC_OldMan(play);
        npcs[0].worldX = (MAX_WORLD_COL / 2 - 3) * TILE_SIZE;
        npcs[0].worldY = (MAX_WORLD_ROW / 2 - 3) * TILE_SIZE;

        npcs[1] = new NPC_OldMan(play);
        npcs[1].worldX = (MAX_WORLD_COL / 2 - 5) * TILE_SIZE;
        npcs[1].worldY = (MAX_WORLD_ROW / 2 - 5) * TILE_SIZE;
    }

    public void update() {
        for(Entity npc : npcs) {
            if(npc != null) {
                npc.update();
            }
        }
    }

    public void draw(Graphics2D graphics2D, Player player) {
        for(Entity npc : npcs) {
            if(npc != null) {
                BufferedImage image = null;
                int worldX = npc.worldX;
                int worldY = npc.worldY;
                int screenX = worldX - player.getWorldX() + player.getScreenX();
                int screenY = worldY - player.getWorldY() + player.getScreenY();

                int left = player.getWorldX() - player.getScreenX();
                int right = player.getWorldX() + player.getScreenX();
                int up = player.getWorldY() - player.getScreenY();
                int down = player.getWorldY() + player.getScreenY();

                if(worldX + TILE_SIZE > left && worldX - TILE_SIZE < right && worldY + TILE_SIZE > up && worldY - TILE_SIZE < down) {
                    switch(npc.direction) {
                        case UP -> {
                            if(npc.spriteNum == 1) {
                                image = npc.up1;
                            }
                            if(npc.spriteNum == 2) {
                                image = npc.up2;
                            }
                        }
                        case LEFT -> {
                            if(npc.spriteNum == 1) {
                                image = npc.left1;
                            }
                            if(npc.spriteNum == 2) {
                                image = npc.left2;
                            }
                        }
                        case DOWN -> {
                            if(npc.spriteNum == 1) {
                                image = npc.down1;
                            }
                            if(npc.spriteNum == 2) {
                                image = npc.down2;
                            }
                        }
                        case RIGHT -> {
                            if(npc.spriteNum == 1) {
                                image = npc.right1;
                            }
                            if(npc.spriteNum == 2) {
                                image = npc.right2;
                            }
                        }
                    }
                    graphics2D.drawImage(image, screenX, screenY, null);
                }
            }
        }
    }

    public Entity[] getNpcs() {
        return npcs;
    }
}
