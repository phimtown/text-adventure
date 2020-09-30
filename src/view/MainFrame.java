package view;

import controller.MainController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainController mainController;
    public MainView mainView;
    public StartView startView;
    public EndView endView;

    public MainFrame(MainController mainController, String name, int x, int y, int width, int height){
        this.mainController = mainController;

        this.setLocation(x,y);
        this.setSize(width,height);
        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setVisible(true);
        this.switchToPanel(mainView.getPanel());
    }

    private void switchToPanel(JPanel panel){
        this.getContentPane().removeAll();
        this.getContentPane().add(panel);
        this.validate();
        this.repaint();
    }

}
