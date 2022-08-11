package states;

import gui.Button;
import main.Scene;

import java.awt.event.MouseEvent;

import static utilities.Constant.AudioManager.MENU;

public class State {
    protected Scene scene;

    public State(Scene scene) {
        this.scene = scene;
    }

    public boolean isBound(MouseEvent e, Button button) {
        return button.getBounds().contains(e.getX(), e.getY());
    }

    public void setGameStates(GameState gameState) {
        switch(gameState) {
            case MENU -> scene.getAudioManager().playMusic(MENU);
        }
        GameState.gameState = gameState;
    }

    public Scene getScene() {
        return scene;
    }
}
