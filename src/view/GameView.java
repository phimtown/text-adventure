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
    private MainController mainController;

    /*
    Ein Objekt der Klasse GameView wird erzeugt.
    Die Referenz mainController wird dem entsprechendem Parameter gleichgesetzt.
    Außerdem wird die Funktion loadPlayer aufgerufen und er Parameter p weitergegeben.
    Zum Schluss wird noch die Funktion buttons aufgerufen.
     */
    public GameView(MainController mainController, Player p) {
        this.mainController = mainController;

        this.loadPlayer(p);
        buttons();
    }

    /*
    Jedem der vier Buttons wird ein ActionListener zugefügt.
    Wenn einer jetzt gedrückt wird, dann wird die Methode answer im mainController mit der jeweiligen Zahl des Buttons als Parameter.
     */
    private void buttons() {
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.answer(1);
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.answer(2);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.answer(3);
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.answer(4);
            }
        });
    }

    /*
    Die Label, die die Werte des Spielers anzeigen, werden erneut den Attributen von player gleichgesetzt.
     */
    public void loadPlayer(Player player) {
        usernameLabel.setText(player.getUsername());
        atkLabel.setText(String.valueOf(player.getAtk()));
        defLabel.setText(String.valueOf(player.getDef()));
        expLabel.setText(String.valueOf(player.getExp()));
        hpLabel.setText(String.valueOf(player.getHp()));
    }

    public JPanel getPanel() {
        return panel;
    }

    /*
    Im Text des Textfeldes wird, in einer neuen Zeile, der Parameter text hinzugefügt.
     */
    public void addText(String text){
        textOutput.setText(textOutput.getText()+text+"\n");
    }

    /*
    Bei allen vier Buttons wird die Methode setEnabled mit dem Parameter false ausgeführt.
    Dadurch sind alle Buttons ausgegraut und die ActionListener reagieren nicht.
     */
    public void deactivateAllButtons(){
        a1Button.setEnabled(false);
        a2Button.setEnabled(false);
        a3Button.setEnabled(false);
        a4Button.setEnabled(false);
    }

    /*
    Es wird der Button mit der jeweiligen Zahl, die dem Parameter i entspricht, wieder enabled.
     */
    public void activateButton(int i){
        switch (i){
            case 1:
                a1Button.setEnabled(true);
                break;
            case 2:
                a2Button.setEnabled(true);
                break;
            case 3:
                a3Button.setEnabled(true);
                break;
            case 4:
                a4Button.setEnabled(true);
                break;
        }
    }
}