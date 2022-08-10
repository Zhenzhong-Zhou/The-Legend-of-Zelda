package states;

import entities.Player;
import gui.EditorBar;
import levels.LevelManager;
import main.Scene;
import objects.ObjectManager;
import tiles.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static states.GameState.*;
import static utilities.Constant.GUI.EditorBar.*;
import static utilities.Constant.SceneConstant.SCENE_WIDTH;
import static utilities.Constant.SceneConstant.TILE_SIZE;

public class Editor extends State implements StateMethods {
    private final EditorBar editorBar;
    private Tile selectedTile;
    private Player player;
    private LevelManager levelManager;
    private ObjectManager objectManager;
    private int mouseX, mouseY;
    private boolean drawSelected;

    public Editor(Scene scene) {
        super(scene);
        // TODO: change later
        editorBar = new EditorBar(0, BAR_Y, SCENE_WIDTH, BAR_HEIGHT, this, scene.getPlay());
        initClasses();
    }

    private void initClasses() {
        levelManager = new LevelManager(scene);
        objectManager = new ObjectManager(scene.getPlay());
        player = new Player(200, 200, 1, TILE_SIZE, TILE_SIZE, scene.getPlay());
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        levelManager.draw(graphics2D, player);
        objectManager.draw(graphics2D, player);
        player.draw(graphics2D);
        editorBar.draw(graphics2D);
        drawSelectedTile(graphics2D);
    }

    private void drawSelectedTile(Graphics2D graphics2D) {
        if(selectedTile != null && drawSelected) {
            graphics2D.drawImage(selectedTile.getSprite(), mouseX, mouseY, TILE_SIZE, TILE_SIZE, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getY() >= BAR_Y) {
            editorBar.mouseClicked(e);
        } else {
            changeTile(mouseX, mouseY);
        }
    }

    private void changeTile(int mouseX, int mouseY) {
        int tileX = mouseX / TILE_SIZE;
        int tileY = mouseY / TILE_SIZE;

        levelManager.getTileId()[tileX][tileY] = selectedTile.getTileId();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getY() >= BAR_Y) {
            editorBar.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getY() >= BAR_Y) {
            editorBar.mouseReleased(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getY() >= BAR_Y - X_SELECTED_TILE) {
            editorBar.mouseMoved(e);
            drawSelected = false;
        } else {
            mouseX = (e.getX() / TILE_SIZE) * TILE_SIZE;
            mouseY = (e.getY() / TILE_SIZE) * TILE_SIZE;
            drawSelected = true;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W -> player.setUp(true);
            case KeyEvent.VK_A -> player.setLeft(true);
            case KeyEvent.VK_S -> player.setDown(true);
            case KeyEvent.VK_D -> player.setRight(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gameState = MENU;
        } else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameState = PLAY;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W -> player.setUp(false);
            case KeyEvent.VK_A -> player.setLeft(false);
            case KeyEvent.VK_S -> player.setDown(false);
            case KeyEvent.VK_D -> player.setRight(false);
        }
    }

    public void setSelectedTile(Tile selectedTile) {
        this.selectedTile = selectedTile;
        drawSelected = true;
    }

    public Player getPlayer() {
        return player;
    }

    public LevelManager getLevelManager() {
        return levelManager;
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    public EditorBar getEditorBar() {
        return editorBar;
    }
}
