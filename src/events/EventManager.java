package events;

import entities.Player;
import states.Play;

import java.awt.*;
import java.awt.event.MouseEvent;

import static utilities.Constant.DirectionConstant.RIGHT;
import static utilities.Constant.DirectionConstant.UP;
import static utilities.Constant.SceneConstant.TILE_SIZE;

public class EventManager {
    private Play play;
    private Rectangle eventRect;
    private int eventRectDefaultX, eventRectDefaultY;

    public EventManager(Play play) {
        this.play = play;

        eventRect = new Rectangle(23, 23, 2, 2);
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent() {
        if(trigger(51, 31, RIGHT)) {damagePit();}
        if(trigger(48, 48, UP)) {damagePit();}
        if(trigger(47, 47, UP)) {healingPool();}
    }

    private boolean trigger(int eventCol, int eventRow, String reqDirection) {
        boolean trigger = false;

        Player player =  play.getPlayer();
        player.getHitbox().x = player.getWorldX() + player.getHitbox().x;
        player.getHitbox().y = player.getWorldY() + player.getHitbox().y;
        eventRect.x = eventCol * TILE_SIZE + eventRect.x;
        eventRect.y = eventRow * TILE_SIZE + eventRect.y;

        if(player.getHitbox().intersects(eventRect)) {
            if(player.getDirection().contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                trigger = true;
            }
        }

        player.getHitbox().x = player.getHitboxDefaultX();
        player.getHitbox().y = player.getHitboxDefaultY();
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return trigger;
    }

    private void damagePit() {
        play.getGui().setCurrentDialogue("You fall into a pit!");
        play.getPlayer().setLife(play.getPlayer().getMaxLives()-1);
    }

    private void healingPool() {
        play.getGui().setCurrentDialogue("You life has been recovered!");
        play.getPlayer().setLife(play.getPlayer().getMaxLives());
    }
}
