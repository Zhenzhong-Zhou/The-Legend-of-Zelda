package main;

import collisions.CollisionDetection;
import entities.Player;
import inputs.KeyboardHandler;
import inputs.MouseHandler;
import objects.Object;
import tiles.TileManager;
import objects.ObjectManager;

import javax.swing.*;
import java.awt.*;

import static utilities.Constants.ScreenConstants.*;

public class Screen extends JPanel {
    private final Game game;
    private final MouseHandler mouseHandler;
    private TileManager tileManager;
    private Player player;
    private CollisionDetection collisionDetection;
    private ObjectManager objectManager;
    public Object[] objects;

    public Screen(Game game) {
        initClasses();

        mouseHandler = new MouseHandler(this);
        this.game = game;
        setScreenSize();
        setDoubleBuffered(true);
        addKeyListener(new KeyboardHandler(this));
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
        setFocusable(true);
        requestFocus();
    }

    private void initClasses() {
        player = new Player(100, 100, 4, this);
        tileManager = new TileManager(this);
        collisionDetection = new CollisionDetection(this);
        objectManager = new ObjectManager(this);
        objects = new Object[10];
    }

    public void setupGame() {
        objectManager.setObjects();
    }

    private void setScreenSize() {
        Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
        setPreferredSize(size);
        System.out.println("Size: " + SCREEN_WIDTH + ", " + SCREEN_HEIGHT);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        game.draw(graphics2D);

        // TILE
        tileManager.draw(graphics2D);

        // OBJECT
        objectManager.draw(graphics2D);

        // PLAYER
        player.draw(graphics2D);
        graphics2D.dispose();
    }

    public Game getGame() {
        return game;
    }

    public CollisionDetection getCollisionDetection() {
        return collisionDetection;
    }

    public Player getPlayer() {
        return player;
    }

    public TileManager getTileManager() {
        return tileManager;
    }
}
