package entities;

import states.Play;

import java.util.Random;

import static utilities.Constant.DirectionConstant.*;
import static utilities.LoadSave.*;

public class NPC_OldMan extends Entity {
    public NPC_OldMan(Play play) {
        super(play);

        getOldManImage();
        setDialogue();
    }

    private void getOldManImage() {
        up1 = GetSpriteAtlas(OLD_MAN_UP_1_IMAGE);
        up2 = GetSpriteAtlas(OLD_MAN_UP_2_IMAGE);
        left1 = GetSpriteAtlas(OLD_MAN_LEFT_1_IMAGE);
        left2 = GetSpriteAtlas(OLD_MAN_LEFT_2_IMAGE);
        down1 = GetSpriteAtlas(OLD_MAN_DOWN_1_IMAGE);
        down2 = GetSpriteAtlas(OLD_MAN_DOWN_2_IMAGE);
        right1 = GetSpriteAtlas(OLD_MAN_RIGHT_1_IMAGE);
        right2 = GetSpriteAtlas(OLD_MAN_RIGHT_2_IMAGE);
    }

    public void setAction() {
        actionLockCounter++;
        if(actionLockCounter == 180) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;    // pick up a number from 1 to 100;
            if(i <= 25) direction = UP;
            if(i > 25 && i <= 50) direction = DOWN;
            if(i > 50 && i <= 75) direction = LEFT;
            if(i > 75) direction = RIGHT;
            actionLockCounter = 0;
        }
    }

    public void setDialogue() {
        dialogues[0] = "Hello, World";
        dialogues[1] = "This is a super long sentence for testing how to deal with second line...........\n" +
                "This is a super long sentence for testing how to deal with second line...........";
        dialogues[2] = "Welcome!";
        dialogues[3] = "Good luck!";
    }

    public void speak() {
        super.speak();
    }
}
