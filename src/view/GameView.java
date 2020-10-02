package view;

import controller.MainController;
import model.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView {

    //Formelemente
    private JPanel panel;
    private JTextPane textOutput;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JLabel hpLabel;
    private JLabel atkLabel;
    private JLabel usernameLabel;
    private JLabel defLabel;
    private JLabel expLabel;

    //Referenzen
    private MainFrame mainFrame;
    private MainController mainController;
    private Player player;

    public GameView(MainFrame mainFrame, MainController mainController, Player p) {
        this.mainFrame = mainFrame;
        this.mainController = mainController;
        this.player = p;
        buttons();
    }

    private void buttons() {
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textOutput.setText(textOutput.getText() + "\n" + mainController.answer(1));
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textOutput.setText(textOutput.getText() + "\n" + mainController.answer(2));
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textOutput.setText(textOutput.getText() + "\n" + mainController.answer(3));
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textOutput.setText(textOutput.getText() + "\n" + mainController.answer(4));
            }
        });
    }

    private void loadPlayer() {
        usernameLabel.setText(player.getUsername());
        atkLabel.setText(String.valueOf(player.getAtk()));
        defLabel.setText(String.valueOf(player.getDef()));
        expLabel.setText(String.valueOf(player.getExp()));
        hpLabel.setText(String.valueOf(player.getHp()));
    }

    public JPanel getPanel() {
        return panel;
    }
}