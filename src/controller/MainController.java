package controller;

import view.MainFrame;

public class MainController {

    private MainFrame mainFrame;

    public MainController() {
        mainFrame = new MainFrame(this, "Text Adventure!!", 500, 500, 800, 600);
    }
}
