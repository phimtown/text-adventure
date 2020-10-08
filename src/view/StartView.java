package view;

import controller.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartView {

    //Formelemente
    private JPanel panel;
    private JButton startButton;
    private JButton exitButton;
    private JTextField usernameTextField;

    //Referenzen
    private MainFrame mainFrame;
    private MainController mainController;

    /*
    Ein Objekt der Klasse StartView wird erzeugt.
    Die Parameter werden an die zugehörigen Referenzen übergeben.
     */
    public StartView(MainFrame mainFrame, MainController mainController) {
        this.mainFrame = mainFrame;
        this.mainController = mainController;

        createListeners();
    }

    public JPanel getPanel() {
        return panel;
    }

    /*
    Dem Button startButton wird ein ActionListener hinzugefügt, der, wenn es nicht leer ist, die Attribute auf auf bestimmte Startwerte gesetzt: Hp=100, Exp=0, Atk=3 und Def=3.
    Außerdem wird dann die Methode play im mainController ausgeführt.
    Wenn der exitButton gedrückt wird, schließt sich das Fenster.
     */
    private void createListeners(){
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!usernameTextField.getText().isEmpty()) {
                    mainController.getPlayer().setUsername(usernameTextField.getText());
                    mainController.getPlayer().setHp(100);
                    mainController.getPlayer().setExp(0);
                    mainController.getPlayer().setAtk(3);
                    mainController.getPlayer().setDef(3);
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
