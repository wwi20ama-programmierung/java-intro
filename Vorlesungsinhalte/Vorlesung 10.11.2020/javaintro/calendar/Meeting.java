package javaintro.calendar;

import java.util.ArrayList;

class Meeting {
    private String title;
    private String room;
    private Time time;
    private Date date;
    private ArrayList<Participant> participants = new ArrayList<>();
    // int[] participants = new int[100000]; -> nicht flexibel genug, reserviert "zu viel" Speicherplatz

    // Konstruktor
    Meeting(String title, String room, Time time, Date date) {
        this.title = title;
        this.room = room;
        this.time = time;
        this.date = date;
        // this.participants = new ArrayList<>(); // Alternative zu direkter Initialisierung bei Deklaration (siehe Zeile 10)
    }

    // fügt einen einzelnen Participant zur "participants"-ArrayList hinzu
    void addParticipant(Participant participant) {
        this.participants.add(participant);
        // Kontrollausgabe zur Bestätigung, dass Teilnehmer hinzugefügt wurde:
        System.out.println("Teilnehmerliste für Meeting " + this.title + " hat eine Länge von " + this.participants.size());
    }

    // Ersetzt die (private) "participants"-ArrayList mit der als Parameter übergebenen
    void addParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    void listMeetingParticipants() {
        // Auf der Basis des von "isLeapYear()" zurückgegebenen Booleans den auszugebenden String bestimmen
        String schaltjahrString = "kein Schaltjahr";
        if(this.date.isLeapYear()) {
            schaltjahrString = "Schaltjahr";
        }

        // Beispiel-Ausgabe: "Diese Teilnehmer nehmen am Meeting Mittagessen am 10.11.2020 (Schaltjahr) um 13:20 teil."
        System.out.println("Diese Teilnehmer nehmen am Meeting " + this.title + " am " + this.date.getInGermanFormat() + " (" + schaltjahrString + ") um " + this.time.getIn24hFormat() + " teil.");

        // für jeden Participant des Meetings die Methode "getParticipantDetails()" aufrufen
        for(int i = 0; i < this.participants.size(); i++) {
            Participant participant = this.participants.get(i); // wir speichern die Objektreferenz zur einfacheren Verwendung in "participant" zwischen
            // Beispiel-Ausgabe: "(1) Teilnehmer Max Mustermann von der Firma ABC"
            System.out.println("(" + (i + 1) + ") " + participant.getParticipantDetails());
        }
    }
}