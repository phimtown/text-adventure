package controller;

import model.Player;
import view.MainFrame;

public class MainController {

    private MainFrame mainFrame;
    private StoryController storyController;
    private FightController fightController;

    private Player player;

    public MainController() {
        player = new Player("", 100, 3, 3, 0);

        mainFrame = new MainFrame(this, "Text Adventure!!", 800, 600);
        storyController = new StoryController(this);
        storyController.getStoryFromTxt();
        fightController = new FightController(player, this, mainFrame);
    }

    public void startNewEvent(){
        if(Math.random()*100<90) {
            storyController.startNewEvent();
            mainFrame.deactivateAllButtons();

            mainFrame.addText(storyController.getActEvent().getIntroduction());

            for (int i = 0; i < storyController.getActEvent().getAllChoices().length; i++) {
                mainFrame.addText(i + 1 + ": " + storyController.getActEvent().getAllChoices()[i].getChoiceIntro());
                mainFrame.activateButton(i + 1);
            }
        }else{
            fightController.createNewCreature();
            fightController.fight();
            checkForEnd();
        }
    }

    public void answer(int answer){
        mainFrame.deactivateAllButtons();
        mainFrame.addText(storyController.getActEvent().getAllChoices()[answer-1].getChoiceOutcome());
        player.setHp(player.getHp()+storyController.getActEvent().getAllChoices()[answer-1].getPar1());
        if(player.getExp()+storyController.getActEvent().getAllChoices()[answer-1].getPar2()>0) {
            player.setExp(player.getExp() + storyController.getActEvent().getAllChoices()[answer - 1].getPar2());
        }else{
            player.setExp(0);
        }
        if(player.getAtk()+storyController.getActEvent().getAllChoices()[answer-1].getPar3()>0) {
            player.setAtk(player.getAtk() + storyController.getActEvent().getAllChoices()[answer - 1].getPar3());
        }else{
            player.setAtk(0);
        }
        if(player.getDef()+storyController.getActEvent().getAllChoices()[answer-1].getPar4()>0) {
            player.setDef(player.getDef() + storyController.getActEvent().getAllChoices()[answer - 1].getPar4());
        }else{
            player.setDef(0);
        }
        mainFrame.updatePlayer(player);
        checkForEnd();
    }

    public void checkForEnd(){
        if(player.getHp()>0) {
            mainFrame.addText("\n");
            startNewEvent();
        }else{
            String[] stats = new String[3];
            stats[0] = String.valueOf(player.getAtk());
            stats[1] = String.valueOf(player.getDef());
            stats[2] = String.valueOf(player.getExp());
            mainFrame.end(stats);
        }
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }
}
