package view;

import controller.MainController;
import model.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartView {

    private JPanel panel;
    private JButton startButton;
    private JButton exitButton;
    private JTextField usernameTextField;
    private MainFrame mainFrame;
    private MainController mainController;

    public StartView(MainFrame mainFrame, MainController mainController) {
        this.mainFrame = mainFrame;
        this.mainController = mainController;

        createListeners();
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createListeners(){
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!usernameTextField.getText().isEmpty()) {
                    mainController.getPlayer().setUsername(usernameTextField.getText());
                    mainFrame.play(mainController.getPlayer());
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });
    }
}
