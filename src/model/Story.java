package model;

public class Story {

    //Referenzen
    private Event[] allEvents = new Event[0];

    /*
    Ein Objekt der Klasse Story wird erzeugt.
     */
    public Story() {}

    /*
    Es wird ein neues Array der Klasse Event, welches um einen Platz größer ist, erstellt.
    Alle werte von allEvents werden übertragen und an den letzten Platz ein neues Event  erstellt.
    Zum Schluss wird allEvents mit dem neuen Array überschrieben.
     */
    public void insertNewEvent() {
        Event[] tmpEventArr = new Event[allEvents.length + 1];
        for (int i = 0; i < allEvents.length; i++) {
            tmpEventArr[i] = allEvents[i];
        }
        tmpEventArr[tmpEventArr.length - 1] = new Event();
        allEvents = tmpEventArr;
    }

    /*
    Es wird ein neues Array von Events erstellt, mit einem Index weniger.
    Alle werte bis auf dem des Indexes des Parameters werden kopiert und anschließend allEvents mit dem neuem Array überschrieben.
     */
    public void deleteEventByIndex(int index) {
        if (index < allEvents.length && index >= 0) {
            Event[] tmpEventArr = new Event[allEvents.length - 1];
            int x = 0;
            for (int i = 0; i < tmpEventArr.length; i++) {
                if (i == index) x = 1;
                tmpEventArr[i] = allEvents[i + x];
            }
            allEvents = tmpEventArr;
        }
    }

    public Event[] getAllEvents() {
        return allEvents;
    }
}
