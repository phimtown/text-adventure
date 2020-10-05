package view;

import controller.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndView {

    private JPanel panel;
    private JButton startAgainButton;
    private JLabel statsLabel;
    private MainFrame mainFrame;
    private MainController mainController;

    /*
        String[] stats: [0] ATK, [1] DEF, [2] EXP
     */

    public EndView(MainFrame mainFrame, MainController mainController, String[] stats) {
        this.mainFrame = mainFrame;
        this.mainController = mainController;
        statsLabel.setText("You've ended  with following stats:\nATK: " + stats[0] + "\nDEF: " + stats[1] + "\nEXP: " + stats[2]);
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
