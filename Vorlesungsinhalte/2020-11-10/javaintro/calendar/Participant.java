package javaintro.calendar;

class Participant {
    private String firstname;
    private String lastname;
    private String company;

    // Konstruktor: Erzeugung des Objekts mit ... = new Participant("Vorname", "Nachname", "Unternehmen");
    Participant(String firstname, String lastname, String company) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
    }

    // Da alle Attribute "private" sind, müssen wir eine Methode anbieten, über die andere Objekte Zugriff auf die Attribute bekommen
    String getParticipantDetails() {
        // Beispiel-Ausgabe: "Teilnehmer Max Mustermann von der Firma ABC" (kein System.out.println(), es wird nur der Wert zurückgegeben!)
        return "Teilnehmer " + this.firstname + " " + this.lastname + " von der Firma " + this.company;
    }
}
