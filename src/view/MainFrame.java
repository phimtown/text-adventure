package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(){

    }

    public void switchPanel(Panel panel){
        this.removeAll();
        this.invalidate();

        this.setContentPane(panel);

        this.revalidate();
    }
}
