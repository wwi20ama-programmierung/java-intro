package javaintro.calendar;

class Main {
  public static void main(String[] args) {
    ////////////////////////////////////////////////////////////////////////////////////////
    // Testfälle für Date- und Time-Klasse
    ////////////////////////////////////////////////////////////////////////////////////////

    Date date1; // Date deklarieren
    date1 = new Date("01", "02", "2020"); // Date initialisieren
    Date date2 = new Date("31", "12", "2022"); // Date deklarieren und initialisieren

    System.out.println(); // leere Zeile als Abstandshalter

    // DateWithInt (Attribute day, month, year haben "int" statt "String" als Typ)
    DateWithInt dateWithInt1 = new DateWithInt(1, 2, 2020);
    DateWithInt dateWithInt2 = new DateWithInt(31, 12, 2022);
    System.out.println("dateWithInt1 (DE): " + dateWithInt1.getInGermanFormat());
    System.out.println("dateWithInt1 (US): " + dateWithInt1.getInUSFormat());
    System.out.println("dateWithInt2 (DE): " + dateWithInt2.getInGermanFormat());
    System.out.println("dateWithInt2 (US): " + dateWithInt2.getInUSFormat());

    System.out.println(); // leere Zeile als Abstandshalter

    // Überprüfung der Validierungslogik in "setDay()"
    System.out.println("Initiales Datum:");
    System.out.println("date1 (DE): " + date1.getInGermanFormat());
    System.out.println("date1 (US): " + date1.getInUSFormat());
    date1.setDay("32"); // darf das Attribut "day" von "date1" nicht überschreiben

    System.out.println(); // leere Zeile als Abstandshalter

    System.out.println("Nach erfolgloser Modifikation:");
    System.out.println("date1 (DE): " + date1.getInGermanFormat());
    System.out.println("date1 (US): " + date1.getInUSFormat());

    System.out.println(); // leere Zeile als Abstandshalter

    date1.setDay("12"); // überschreibt das Attribtu "day" von "date1"

    System.out.println("Nach erfolgreicher Modifikation:");
    System.out.println("date1 (DE): " + date1.getInGermanFormat());
    System.out.println("date1 (US): " + date1.getInUSFormat());
    System.out.println("date2 (DE): " + date2.getInGermanFormat());
    System.out.println("date2 (DE): " + date2.getInUSFormat());

    System.out.println(); // leere Zeile als Abstandshalter

    // Testfall für Schaltjahr-Methode
    System.out.println("date1 ist Schaltjahr: " + date1.isLeapYear());
    System.out.println("date2 ist Schaltjahr: " + date2.isLeapYear());

    System.out.println(); // leere Zeile als Abstandshalter

    // Testen der Time-Objekte
    Time.selfTest(); // da "static" muss die Methode über die Klasse "Time" und nicht über ein Objekt der Klasse "Time" aufgerufen werden!
    Time time1 = new Time(2, 34);
    Time time2 = new Time(13, 1);
    Time time3 = new Time(0, 15);

    System.out.println("time1 (24h): " + time1.getIn24hFormat()); // 2:34
    System.out.println("time2 (24h): " + time2.getIn24hFormat()); // 13:1
    System.out.println("time3 (24h): " + time3.getIn24hFormat()); // 0:15

    System.out.println("time1 (12h): " + time1.getIn12hFormat()); // 2:34 a. m.
    System.out.println("time2 (12h): " + time2.getIn12hFormat()); // 1:1 p. m.
    System.out.println("time3 (12h): " + time3.getIn12hFormat()); // 12:15 a. m.
    // 1 = 00000000000000...01 (bei int werden führende Nullen nicht angezeigt/gespeichert)

    System.out.println(time3.getIn24hFormat()); // 0:15

    System.out.println(); // leere Zeile als Abstandshalter

    ////////////////////////////////////////////////////////////////////////////////////////
    // Participants erzeugen
    ////////////////////////////////////////////////////////////////////////////////////////

    Participant participant1 = new Participant("Max", "Mustermann", "ABC");
    Participant participant2 = new Participant("Erika", "Mustermann", "DEF");

    // Testausgabe der Teilnehmer-Details
    System.out.println(participant1.getParticipantDetails());
    System.out.println(participant2.getParticipantDetails());

    System.out.println(); // leere Zeile als Abstandshalter

    ////////////////////////////////////////////////////////////////////////////////////////
    // Meetings erzeugen
    ////////////////////////////////////////////////////////////////////////////////////////
    Meeting meeting1 = new Meeting("Mittagessen", "Kantine", time2, date1);
    // 13:1, 12.02.2020
    meeting1.addParticipant(participant1);
    meeting1.addParticipant(participant2);

    // Neu erzeugte Objekte können auch direkt als Parameter an Methoden übergeben werden:
    meeting1.addParticipant(new Participant("Horst", "Mustermann", "DEF"));

    System.out.println(); // leere Zeile als Abstandshalter

    // Testen der Methode "listMeetingParticipants()" (wird später im Calendar aufgerufen)
    meeting1.listMeetingParticipants();

    System.out.println(); // leere Zeile als Abstandshalter

    // Calendar testen
    Calendar myCalendar = new Calendar();

    // Meetings hinzufügen
    myCalendar.addMeeting(meeting1);
    // ... oder alles inline (nicht unbedingt empfohlen, da schwer lesbar und fehleranfällig)
    Meeting meeting2 = new Meeting("Produktplanung", "Meetingraum 42", new Time(16,0), new Date("11", "11","2020"));
    meeting2.addParticipant(new Participant("Ralph", "Otto", "XYZ"));
    meeting2.addParticipant(participant1);

    myCalendar.addMeeting(meeting2);

    System.out.println(); // leere Zeile als Abstandshalter

    ////////////////////////////////////////////////////////////////////////////////////////
    // finale Ausgabe aller Meetings im Kalender
    ////////////////////////////////////////////////////////////////////////////////////////
    myCalendar.listMeetings();
  }
}