package model;

public class Player extends Creature {


    private String username;
    private int exp;
    private int eventsDone;

    public Player(String username, int hp, int atk, int def){
        super(username, hp, atk, def);
        this.exp = 0;
        eventsDone = 0;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) { this.username = username; }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getEventsDone() {
        return eventsDone;
    }

    public void setEventsDone(int eventsDone) {
        this.eventsDone = eventsDone;
    }
}