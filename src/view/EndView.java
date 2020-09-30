package view;

import controller.MainController;

import javax.swing.*;

public class EndView {

    private JPanel panel;
    private MainFrame mainFrame;
    private MainController mainController;

    public EndView(MainFrame mainFrame, MainController mainController) {
        this.mainFrame = mainFrame;
        this.mainController = mainController;
    }

    public JPanel getPanel() {
        return panel;
    }
}
