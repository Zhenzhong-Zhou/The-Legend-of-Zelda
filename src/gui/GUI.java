package gui;

import main.Scene;

import java.awt.*;

import static utilities.Constant.SceneConstant.SCENE_WIDTH;
import static utilities.LoadSave.*;

public class GUI {
    private final Scene scene;
    private final int messageCounter = 0;
    private Font maruMonica, purisaB;
    private boolean notify;
    private String currentDialogue = "";
    private boolean gameCompleted;
    private double timer;
    private PauseOverlay pauseOverlay;
    private DialogueOverlay dialogueOverlay;

    public GUI(Scene scene) {
        this.scene = scene;

        initFont();
        initOverlays();
    }

    private void initFont() {
        maruMonica = GetFont(MARU_MONICA);
        purisaB = GetFont(PURISA_BOLD);
    }

    private void initOverlays() {
        pauseOverlay = new PauseOverlay(this);
        dialogueOverlay = new DialogueOverlay(this);
    }

    public void displayMessage(String text) {
        currentDialogue = text;
        notify = true;
    }

    public void draw(Graphics2D graphics2D) {

    }

    public int getHorizonCenteredText(Graphics2D graphics2D, String text) {
        int length = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();
        return SCENE_WIDTH / 2 - length / 2;
    }

    public void drawSubWindow(Graphics2D graphics2D, int x, int y, int width, int height) {
        Color color = new Color(0, 0, 0, 210);
        graphics2D.setColor(color);
        graphics2D.fillRoundRect(x, y, width, height, 35, 35);

        color = new Color(255, 255, 255);
        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public void drawDialogue(Graphics2D graphics2D, String currentDialogue, int x, int y) {
        if(currentDialogue != null) {
            graphics2D.drawString(currentDialogue, x, y);
        }
    }

    public void resume() {
        scene.getPlay().setPaused(false);
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

    public String getCurrentDialogue() {
        return currentDialogue;
    }

    public void setCurrentDialogue(String currentDialogue) {
        this.currentDialogue = currentDialogue;
    }

    public PauseOverlay getPauseOverlay() {
        return pauseOverlay;
    }

    public DialogueOverlay getDialogueOverlay() {
        return dialogueOverlay;
    }
}
