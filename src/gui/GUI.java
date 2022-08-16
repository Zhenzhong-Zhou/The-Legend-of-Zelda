package gui;

import states.Play;

import java.awt.*;

import static utilities.Constant.SceneConstant.SCENE_WIDTH;
import static utilities.LoadSave.*;

public class GUI {
    private final Play play;
    private Font maruMonica, purisaB;
    private boolean notify;
    private String message = "";
    private final int messageCounter = 0;
    private boolean gameCompleted;
    private double timer;
    private PauseOverlay pauseOverlay;

    public GUI(Play play) {
        this.play = play;

        initFont();
        initOverlays();
    }

    private void initFont() {
        maruMonica = GetFont(MARU_MONICA);
        purisaB = GetFont(PURISA_BOLD);
    }

    private void initOverlays() {
        pauseOverlay = new PauseOverlay(this);
    }

    public void displayMessage(String text) {
        message = text;
        notify = true;
    }

    public void draw(Graphics2D graphics2D) {

    }

    public int getHorizonCenteredText(Graphics2D graphics2D, String text) {
        int length = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();
        return SCENE_WIDTH / 2 - length / 2;
    }

    public boolean isGameCompleted() {
        return gameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        this.gameCompleted = gameCompleted;
    }

    public Font getMaruMonica() {
        return maruMonica;
    }

    public Font getPurisaB() {
        return purisaB;
    }

    public PauseOverlay getPauseOverlay() {
        return pauseOverlay;
    }
}
