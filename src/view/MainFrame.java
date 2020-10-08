package view;

import controller.MainController;
import model.Player;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //Referenzen
    public MainController mainController;
    public StartView startView;
    public GameView gameView;
    public EndView endView;

    /*
    Ein Objekt der Klasse MainFrame wird mit den entsprechenden Parametern erzeugt und ein Objekt der Klasse MainController wird übergeben.
    Außerdem wird ein Objekt der Klasse StartView erstellt.
    Es werden Standardeinstellungen am Fenster gesetzt.
     */
    public MainFrame(MainController mainController, String name, int width, int height){
        this.mainController = mainController;
        this.startView = new StartView(this, mainController);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int w = gd.getDisplayMode().getWidth();
        int h = gd.getDisplayMode().getHeight();

        this.setLocation(w/2 - width/2, h/2 - height/2);
        this.setSize(width,height);
        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setVisible(true);
        this.switchToPanel(startView.getPanel());
    }

    /*
    Aller Inhalt auf dem Fenster wird entfernt und das neue Panel ein das Fenster gesetzt.
     */
    private void switchToPanel(JPanel panel){
        this.getContentPane().removeAll();
        this.getContentPane().add(panel);
        this.validate();
        this.repaint();
    }

    /*
    Es wird ein neues Objekt der Klasse GameView erstellt. Dann wird die eigene Methode switchToPanel(), mit dem panel des neu erstellen gameView als Parameter, aufgerufen.
    Anschließend wird die Methode startNewEvent im mainController aufgerufen.
     */
    public void play(Player p){
        gameView = new GameView(mainController, p);
        this.switchToPanel(gameView.getPanel());
        mainController.startNewEvent();
    }

    /*
    Es wird die Methode switchToPanel, mit dem panel der startView als Parameter, aufgerufen.
     */
    public void restart() {
        this.switchToPanel(startView.getPanel());
    }

    /*
    Es wird ein neues Objekt der Klasse Endview, mit den Parametern stats und a als Parameter, erstellt.
    Anschließend wird die eigene Methode switchToPanel(), mit dem panel des neu erstellen endView als Parameter, aufgerufen.
     */
    public void end(String[] stats, int a) {
        //String[] stats: [0] ATK, [1] DEF, [2] EXP
        EndView endView = new EndView(this, stats, a);
        this.switchToPanel(endView.getPanel());
    }

    /*
    Es wird die Methode addText von gameView aufgerufen und der Parameter text übergeben.
     */
    public void addText(String text){
        this.gameView.addText(text);
    }

    /*
    Ruft die Methode deactivateAllButtons in gameView auf.
     */
    public void deactivateAllButtons(){
        gameView.deactivateAllButtons();
    }

    /*
    Ruft die Methode activateButton in gameView auf.
     */
    public void activateButton(int i){
        gameView.activateButton(i);
    }

    /*
    Ruft die Methode loadPlayer in gameView auf.

     */
    public void updatePlayer(Player player){
        gameView.loadPlayer(player);
    }
}
