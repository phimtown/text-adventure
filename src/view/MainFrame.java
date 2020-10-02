package view;

import controller.MainController;
import model.Player;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainController mainController;
    public StartView startView;
    public EndView endView;

    public MainFrame(MainController mainController, String name, int x, int y, int width, int height){
        this.mainController = mainController;
        this.startView = new StartView(this, mainController);
        this.endView = new EndView(this, mainController);

        this.setLocation(x,y);
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
