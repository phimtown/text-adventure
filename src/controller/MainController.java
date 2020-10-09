package controller;

import model.Player;
import view.MainFrame;

public class MainController {

    private MainFrame mainFrame;
    private StoryController storyController;
    private FightController fightController;

    private Player player;

    /*
    Ein Objekt der Klasse MainController wird erzeugt und instanziiert ein Objekt der Klasse Player, MainFrame, StoryController und FightController.
     */
    public MainController() {
        player = new Player("", 100, 3, 3);

        mainFrame = new MainFrame(this, "Text Adventure!!", 800, 600);
        storyController = new StoryController();
        storyController.getStoryFromTxt();
        fightController = new FightController(player, mainFrame);
    }

    /*
    Mit einer wahrscheinlichkeit von 90% wird die Methode startNewEvent im storyController aufgerufen, alle Buttons deaktiviert und die Einleitung des neuen Events im Textfeld ausgegeben.
    Bei den anderen 10% wird eine neue Creature im fightController erschaffen und auch gekämpft. Danach wird die Methode checkForEnd  aufgerufen.
     */
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

    /*
    Es wird das Outcome von der gewählten antwort ausgegeben und daraufhin die stats des Spielers entsprechend verändert. Danach wird die Methode checkForEnd aufgerufen.
     */
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

    /*
    Das Attribut eventsDone vom player wird um eins erhöht. Wenn die Leben des Spielers kleiner gleich null sind, wird die Methode end in mainFrame aufgerufen und als Parameter null übergeben.
    Wenn die XP des Spielers größer gleich 1000 ist und eventsDone größer gleich 10, wird die Methode end in mainFrame aufgerufen und als Parameter eins übergeben.
    Wenn nichts davon der Fall ist, wird die Methode startNewEvent aufgerufen.
     */
    public void checkForEnd(){
        player.setEventsDone(player.getEventsDone()+1);

        if(player.getHp()<=0) {
            String[] stats = new String[3];
            stats[0] = String.valueOf(player.getAtk());
            stats[1] = String.valueOf(player.getDef());
            stats[2] = String.valueOf(player.getExp());
            mainFrame.end(stats, 0);
        }else if(player.getExp()>=1000 && player.getEventsDone()>=10) {
            String[] stats = new String[3];
            stats[0] = String.valueOf(player.getAtk());
            stats[1] = String.valueOf(player.getDef());
            stats[2] = String.valueOf(player.getExp());
            mainFrame.end(stats, 1);
        }else{
            mainFrame.addText("\n");
            startNewEvent();
        }
    }

    public Player getPlayer(){
        return player;
    }
}
