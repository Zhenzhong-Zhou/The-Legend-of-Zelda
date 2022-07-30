package main;

public class Game {
    private Window window;
    private Screen screen;

    public Game() {
        screen = new Screen(this);
        window = new Window(screen);
    }
}
