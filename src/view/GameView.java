package view;

import controller.MainController;

import javax.swing.*;

public class GameView {

    private JPanel panel;
    private JTextPane textOutput;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JLabel liveLabel;
    private MainFrame mainFrame;
    private MainController mainController;

    public GameView(MainFrame mainFrame, MainController mainController) {
        this.mainFrame = mainFrame;
        this.mainController = mainController;
    }

    public JPanel getPanel() {
        return panel;
    }
}
