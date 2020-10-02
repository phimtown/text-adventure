package view;

import controller.MainController;
import model.Player;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainController mainController;
    public StartView startView;
    public EndView endView;

    public MainFrame(MainController mainController, String name, int width, int height){
        this.mainController = mainController;
        this.startView = new StartView(this, mainController);
        this.endView = new EndView(this, mainController);

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

    private void switchToPanel(JPanel panel){
        this.getContentPane().removeAll();
        this.getContentPane().add(panel);
        this.validate();
        this.repaint();
    }

    public void play(Player p){
        GameView gameView = new GameView(this, mainController, p);
        this.switchToPanel(gameView.getPanel());
    }

    public void restart() {
        this.switchToPanel(startView.getPanel());
    }

    public void end() {
        this.switchToPanel(endView.getPanel());
    }
}
