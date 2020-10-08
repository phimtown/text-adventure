package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndView {

    private JPanel panel;
    private JButton startAgainButton;
    private JLabel statsLabel;
    private JLabel what;

    private MainFrame mainFrame;


    //String[] stats: [0] ATK, [1] DEF, [2] EXP


    public EndView(MainFrame mainFrame, String[] stats, int a) {
        this.mainFrame = mainFrame;
        if(a == 0) {
            what.setText("You've lost!");
        }else{
            what.setText("You won!");
        }
        statsLabel.setText("You've ended  with following stats:\n  ATK: " + stats[0] + "\n  DEF: " + stats[1] + "\n  EXP: " + stats[2]);

        createListeners();
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createListeners(){
        startAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.restart();
            }
        });
    }
}
