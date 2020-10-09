package model;

public class Wolf extends Creature {

    /*
    Ein Objekt der Klasse Wolf wird erzeugt und übergibt hierbei “Wolf” und die parameter in den Konstruktor von Creature.
     */
    public Wolf(int hp, int atk, int def){
        super("Wolf", hp, atk, def);
    }
}
