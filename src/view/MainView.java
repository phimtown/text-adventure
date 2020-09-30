package view;

import controller.MainController;

import javax.swing.*;

public class MainView {

    private JPanel panel;
    private MainFrame mainFrame;
    private MainController mainController;

    public MainView(MainFrame mainFrame, MainController mainController) {
        this.mainFrame = mainFrame;
        this.mainController = mainController;
    }

    public JPanel getPanel() {
        return panel;
    }
}
