package controller;

import model.Bear;
import model.Creature;
import model.Player;
import model.Wolf;
import view.MainFrame;

public class FightController {

    private Creature creature;
    private Player player;
    private MainController mainController;
    private MainFrame mainFrame;


    public FightController(Player player, MainController mainController, MainFrame mainFrame){
        this.player = player;
        this.mainController = mainController;
        this.mainFrame = mainFrame;
    }

    public void createNewCreature(){
        switch ((int)(Math.random()*2)){
            case 0:
                creature = new Bear((int)(10+Math.random()*player.getHp()), (int)(Math.random()*player.getAtk()), (int)(Math.random()*player.getDef()));
                break;
            case 1:
                creature = new Wolf((int)(5+Math.random()*player.getHp()), (int)(Math.random()*player.getAtk()), (int)(Math.random()*player.getDef()));
                break;
        }
        mainFrame.addText("Oh, ein wilder "+creature.getName()+" erscheint.");
        mainFrame.addText("Du musst kämpfen!");
    }

    public void fight(){
        while(player.getHp()>0 && creature.getHp()>0){
            mainFrame.addText("Der "+creature.getName()+" hat noch "+creature.getHp()+" Lebenspunkte.");
            creature.setHp(creature.getHp()-(int)((Math.sqrt((player.getAtk()+creature.getDef())^2))*Math.random()*2));
            player.setHp(player.getHp()-(int)((Math.sqrt((creature.getAtk()+player.getDef())^2))*Math.random()*3));
            mainFrame.updatePlayer(player);
        }
        if(creature.getHp()<=0){
            int xp = (int)(Math.random()*100);
            player.setExp(player.getExp()+xp);
            mainFrame.addText("Du hast den "+creature.getName()+" besiegt.");
        }
    }
}
