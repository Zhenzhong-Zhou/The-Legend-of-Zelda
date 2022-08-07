package main;

public class Game {
    public Game() {
        Scene scene = new Scene(this);
        new Window(scene);

        scene.start();
    }
}
