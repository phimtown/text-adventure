package model;

public abstract class Creature {

    protected String name;
    protected int hp;
    protected int atk;
    protected int def;

    /*
    Ein Objekt der Klasse Creature wird erzeugt und die Attribute den entsprechenden Parametern gleichgesetzt.
     */
    public Creature(String name, int hp, int atk, int def){
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }
}
