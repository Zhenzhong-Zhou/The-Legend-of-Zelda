package main;

import static utilities.LoadSave.CreatedFolder;

public class Game {
    public Game() {
        CreatedFolder();

        Scene scene = new Scene(this);
        new Window(scene);

        scene.start();
    }
}
