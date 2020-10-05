package model;

public class Player {


    private String username;
    private int hp, atk, def, exp;

    public Player(String username, int hp, int atk, int def, int exp) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.exp = exp;
        this.username = username;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public int getHp() { return hp; }

    public void setHp(int hp) { this.hp = hp; }

    public int getAtk() { return atk; }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
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
}