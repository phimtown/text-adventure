package controller;

import view.MainFrame;

public class MainController {

    private MainFrame mainFrame;
    private StoryController storyController;

    public MainController() {
        mainFrame = new MainFrame(this, "Text Adventure!!", 800, 600);
        storyController = new StoryController(this);
        storyController.getStoryFromTxt();
    }

    public void startNewEvent(){
        storyController.startNewEvent();
        mainFrame.setText(storyController.getActEvent().getIntroduction());
    }

}
