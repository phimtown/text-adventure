package model;

public class Event {

    //Referenzen
    private String introduction = "";
    private Choice[] allChoices = new Choice[0];

    /*
    Ein Objekt der Klasse Event wird erzeugt.
     */
    public Event() {}

    /*
    Es wird ein neues Array der Klasse Choice, welches um einen Platz größer ist, erstellt.
    Alle werte von allChoices werden übertragen und an den letzten Platz eine neue Choice erstellt.
    Zum Schluss wird allChoices mit dem neuen Array überschrieben.
     */
    public void insertNewChoice() {
        Choice[] tmpChoiceArr = new Choice[allChoices.length + 1];
        for (int i = 0; i < allChoices.length; i++) {
            tmpChoiceArr[i] = allChoices[i];
        }
        tmpChoiceArr[tmpChoiceArr.length - 1] = new Choice();
        allChoices = tmpChoiceArr;
    }

    /*
    Es wird ein neues Array von Choiceerstellt, mit einem Index weniger.
    Alle werte bis auf dem des Indexes des Parameters werden kopiert und anschließend allChoices mit dem neuem Array überschrieben.
     */
    public void deleteChoiceByIndex(int index) {
        if (index < allChoices.length && index >= 0) {
            Choice[] tmpChoiceArr = new Choice[allChoices.length - 1];
            int x = 0;
            for (int i = 0; i < tmpChoiceArr.length; i++) {
                if (i == index) x = 1;
                tmpChoiceArr[i] = allChoices[i + x];
            }
            allChoices = tmpChoiceArr;
        }
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Choice[] getAllChoices() {
        return allChoices;
    }
}
