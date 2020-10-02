package view;

import controller.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndView {

    private JPanel panel;
    private JButton startAgainButton;
    private MainFrame mainFrame;
    private MainController mainController;

    public EndView(MainFrame mainFrame, MainController mainController) {
        this.mainFrame = mainFrame;
        this.mainController = mainController;
        startAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.restart();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
