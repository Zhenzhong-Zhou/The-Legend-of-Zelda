package main;

public class Game {
    private Window window;
    private Screen screen;

    public Game() {
        initClasses();

        screen = new Screen(this);
        window = new Window(screen);
    }

    private void initClasses() {

    }
}
