package view;

import controller.MainController;
import model.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView {

    private JPanel panel;
    private JTextPane textOutput;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JLabel hpLabel;
    private JLabel atkLabel;
    private JLabel usernameLabel;
    private MainFrame mainFrame;
    private MainController mainController;

    public GameView(MainFrame mainFrame, MainController mainController, Player p) {
        this.mainFrame = mainFrame;
        this.mainController = mainController;
        usernameLabel.setText(p.getUsername());
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mainController.answer(1);
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mainController.answer(2);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mainController.answer(3);
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mainController.answer(4);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
