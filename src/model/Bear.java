package model;

public class Bear extends Creature {

    /*
    Ein Objekt der Klasse Bear wird erzeugt und übergibt hierbei “Bär” und die parameter in den Konstruktor von Creature.
     */
    public Bear(int hp, int atk, int def){
        super("Bär", hp, atk, def);
    }

}
