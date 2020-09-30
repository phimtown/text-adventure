package view;

import controller.MainController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainController mainController;
    public GameView gameView;
    public StartView startView;
    public EndView endView;

    public MainFrame(MainController mainController, String name, int x, int y, int width, int height){
        this.mainController = mainController;
        this.gameView = new GameView(this, mainController);
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

    public void play(){
        switchToPanel(gameView.getPanel());
    }

}
