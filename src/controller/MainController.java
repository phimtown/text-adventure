package controller;

import model.Player;
import view.MainFrame;

public class MainController {

    private MainFrame mainFrame;
    private StoryController storyController;

    private Player player;

    public MainController() {
        mainFrame = new MainFrame(this, "Text Adventure!!", 800, 600);
        storyController = new StoryController(this);
        storyController.getStoryFromTxt();
    }

    public void startNewEvent(){
        storyController.startNewEvent();
        mainFrame.deactivateAllButtons();

        mainFrame.setText(storyController.getActEvent().getIntroduction());

        for(int i = 0; i<storyController.getActEvent().getAllChoices().length; i++) {
            mainFrame.setText(i+1+": "+storyController.getActEvent().getAllChoices()[i].getChoiceIntro());
            mainFrame.activateButton(i+1);
        }
    }

    public void answer(int answer){
        mainFrame.deactivateAllButtons();
        mainFrame.setText(storyController.getActEvent().getAllChoices()[answer-1].getChoiceOutcome());
        player.setHp(player.getHp()+storyController.getActEvent().getAllChoices()[answer-1].getPar1());
        player.setExp(player.getExp()+storyController.getActEvent().getAllChoices()[answer-1].getPar2());
        player.setAtk(player.getAtk()+storyController.getActEvent().getAllChoices()[answer-1].getPar3());
        player.setDef(player.getDef()+storyController.getActEvent().getAllChoices()[answer-1].getPar4());
        mainFrame.updatePlayer(player);

        mainFrame.setText("\n");
        startNewEvent();
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }
}
