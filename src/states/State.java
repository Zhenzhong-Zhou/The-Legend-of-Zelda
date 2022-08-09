package states;

import main.Scene;

public class State {
    protected Scene scene;

    public State(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}
