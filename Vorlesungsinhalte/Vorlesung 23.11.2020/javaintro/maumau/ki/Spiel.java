package javaintro.maumau.ki;

import java.util.Scanner;
import java.util.ArrayList;

public class Spiel {
    // Attribute
    private ArrayList<Spieler> spieler = new ArrayList<>(); // speichert Objekte der Klasse Spieler sowie aller Subklassen

    // Theoretisch könnten mehrere "Spiel"-Objekte existieren (z. B. verschiedene "Räume" bei einem Online-Mau-Mau)
    // Deshalb gehört zu jedem Spiel-Objekt ein eigener "ablagestapel" und "kartenstapel"
    private Stapel ablagestapel = new Stapel();
    private Stapel kartenstapel = new Stapel();

    // Es reicht, den Eingabe-Leser für die Konsole einmalig zu erzeugen (Konstante, da "final")
    private final Scanner eingabeLeser = new Scanner(System.in);

    // Wir speichern den aktuellen Spieler im Spiel, da es zu jeder Zeit nur einen geben kann.
    // Folglich würde es keinen Sinn machen, wenn jeder Spieler (= jedes Spieler-Objekt) ein Attribut "aktuellerSpieler" hätte
    private Spieler aktuellerSpieler;

    // Konstruktor
    public Spiel() {
        // Sobald ein Spiel-Objekt erzeugt wird, initialisieren wir den Kartenstapel...
        this.stapelInitialisieren(this.kartenstapel);
        // ... mischen ihn ...
        this.kartenstapel.mischen();
        // ... und ziehen eine Karte für den Ablagestapel.
        this.kartenstapel.ziehen(this.ablagestapel);
    }

    // Methoden
    public Spieler getAktuellerSpieler() {
        return this.aktuellerSpieler;
    }

    public void setAktuellerSpieler(Spieler spieler) {
        this.aktuellerSpieler = spieler;
    }

    // Durch diese "Hilfsmethode" sparen wir uns den "Umweg" über die ArrayList bei Aufrufen "von außen"
    // Außerdem macht es Sinn, dass ein Spiel "Karten geben" kann (-> Methode).
    public void gebeKarten(Stapel hand) {
        this.kartenstapel.geben(hand);
    }

    // Was passiert alles bei einem Spielzug?
    public void zug() {
        // Aktuellen Spieler auf seinen Zug hineweisen
        Spieler aktuellerSpieler = this.getAktuellerSpieler();
        System.out.println(aktuellerSpieler.getName() + ", Du bist am Zug.");

        // Dem Spieler mitteilen, welche Karte gerade oben auf dem Ablagestapel liegt
        Karte karte = this.ablagestapel.getObereKarte();
        System.out.println("Auf dem Ablagestapel liegt ein(e) " + karte.getSymbol() + " " + karte.getWert());

        // Alle möglichen Karten der Spielerhand an der Konsole ausgeben
        System.out.println("Deine Karten sind:");
        aktuellerSpieler.getHand().listKarten();

        // Spieler nach Eingabe fragen
        System.out.println("Welche Karte möchtest Du spielen? (Nummer oder 'z' zum Ziehen) ");
        String eingabe;

        // if(aktuellerSpieler.getClass() == KI.class) { -> Alternative Lösungsmöglichkeit ohne die Verwendung eines separaten Attributs (z. B. "isKI")
        if (aktuellerSpieler.isKI) {
            // ACHTUNG: Typumwandlung notwendig, da ein "Spieler"-Objekt im Gegensatz zum "KI"-Objekt keine "getNextAction()"-Methode kennt.
            KI kiSpieler = (KI) aktuellerSpieler;

            // Unser Ansatz: KI-"Eingabe" -> wir erwarten die gleiche Eingabe ("z" oder Index der Karte + 1) von der KI wie vom Spieler
            eingabe = kiSpieler.getNextAction(karte);
        } else {
            // Benutzereingabe lesen (wartet auf "Enter" an der Konsole)
            eingabe = eingabeLeser.next(); // Auf String-Eingabe warten und zurückgeben
        }

        // Diesen Code können wir sowohl für (menschliche) Spieler als auch für Computergegner verwenden, da beide "z" oder den Kartenindex + 1 zurückgeben.
        if (eingabe.equals("z")) {
            this.kartenstapel.neuMischen(this.ablagestapel); // wird nur ausgeführt, falls Kartenstapel leer

            // Ziehen (Karte von Kartenstapel auf Spieler-Hand (= Stapel) "verschieben")
            this.kartenstapel.ziehen(this.aktuellerSpieler.getHand());
        } else {
            // Wir gehen (gutgläubig) davon aus, dass wir einen Integer-Wert vom Spieler erhalten, wenn er nicht "z" eingegeben hat
            int kartenNummer = Integer.parseInt(eingabe) - 1; // da Array-Indizes bei 0 anfangen


            Karte ausgewaehlteKarte = aktuellerSpieler.getHand().getAtIndex(kartenNummer);
            if (ausgewaehlteKarte.pruefe(karte)) {
                // lege sie auf den Ablagestapel
                this.ablagestapel.addKarte(ausgewaehlteKarte);
                // entferne sie von der Hand des Spielers
                aktuellerSpieler.getHand().removeKarte(ausgewaehlteKarte);
            } else {
                System.out.println("Ungültiger Spielzug.");
                this.zug(); // Zug wiederholen
            }
        }
    }

    public void addSpieler(Spieler spieler) {
        // Neuen Spieler zum Spiel hinzufügen ...
        this.spieler.add(spieler);
        // ... und direkt die Karten auf die Hand geben
        this.gebeKarten(spieler.getHand());
    }

    // Sind alle Spieler dem Spiel "beigetreten", können wir starten
    public void start() {
        // Initial ist der zuerst hinzugefügte Spieler am Zug
        this.setAktuellerSpieler(this.spieler.get(0));

        // Spiel-Loop
        while (this.getWinner() == null) {
            this.zug();

            System.out.println(); // Abstandshalter

            this.setNextPlayer();
        }

        // Welcher der Spieler hat gewonnen?
        Spieler gewinner = this.getWinner();
        System.out.println(gewinner.getName() + " hat das Spiel gewonnen.");
    }

    // Hilfsmethode, um dynamisch überprüfen zu können, ob und falls ja, welcher der n Spieler gewonnen hat
    public Spieler getWinner() {
        // Über alle Spieler loopen
        for (Spieler player : this.spieler) {
            // Keine Karten mehr auf der Hand?
            if (player.getHand().getSize() == 0) {
                return player; // Spieler zurückgeben
            }
        }

        return null; // ansonsten eine leere Referenz zurückgeben
    }

    // Nächsten Spieler (im Uhrzeigersinn) ermitteln
    public void setNextPlayer() {
        // Den Index vom aktuellenSpieler in der Spieler-ArrayList ermitteln
        int aktuellerSpielerIndex = this.spieler.indexOf(this.getAktuellerSpieler());
        // Den Index des nächsten Spielers (im Uhrzeigersinn) berechnen
        int naechsterSpielerIndex = (aktuellerSpielerIndex + 1) % this.spieler.size(); // modulo (%), da wir am Ende der ArrayList wieder bei Spieler 0 weitermachen möchten
        // Nächsten Spieler als solchen setzen
        this.setAktuellerSpieler(this.spieler.get(naechsterSpielerIndex));
    }

    // "Hilfsmethode" zum Initialisieren der vorgegeben Spielkarten
    public void stapelInitialisieren(Stapel stapel) {
        // Wir erhalten als Parameter die Stapel-Referenz, d.h. wir können über addKarte() dem Stapel-Objekt neue Elemente hinzufügen

        // Schreibweise 1: Deklaration und Initialisierung getrennt von Übergabe an Methode
        Karte karte1 = new Karte("Kreuz", "Sieben");
        stapel.addKarte(karte1);
        // Schreibweise 2: inline (Initialisierung und Übergabe an Methode in einem Schritt)
        stapel.addKarte(new Karte("Kreuz", "Acht"));
        stapel.addKarte(new Karte("Kreuz", "Neun"));
        stapel.addKarte(new Karte("Kreuz", "Zehn"));
        stapel.addKarte(new Karte("Kreuz", "Bube"));
        stapel.addKarte(new Karte("Kreuz", "Dame"));
        stapel.addKarte(new Karte("Kreuz", "König"));
        stapel.addKarte(new Karte("Kreuz", "Ass"));

        stapel.addKarte(new Karte("Pik", "Sieben"));
        stapel.addKarte(new Karte("Pik", "Acht"));
        stapel.addKarte(new Karte("Pik", "Neun"));
        stapel.addKarte(new Karte("Pik", "Zehn"));
        stapel.addKarte(new Karte("Pik", "Bube"));
        stapel.addKarte(new Karte("Pik", "Dame"));
        stapel.addKarte(new Karte("Pik", "König"));
        stapel.addKarte(new Karte("Pik", "Ass"));

        stapel.addKarte(new Karte("Herz", "Sieben"));
        stapel.addKarte(new Karte("Herz", "Acht"));
        stapel.addKarte(new Karte("Herz", "Neun"));
        stapel.addKarte(new Karte("Herz", "Zehn"));
        stapel.addKarte(new Karte("Herz", "Bube"));
        stapel.addKarte(new Karte("Herz", "Dame"));
        stapel.addKarte(new Karte("Herz", "König"));
        stapel.addKarte(new Karte("Herz", "Ass"));

        stapel.addKarte(new Karte("Karo", "Sieben"));
        stapel.addKarte(new Karte("Karo", "Acht"));
        stapel.addKarte(new Karte("Karo", "Neun"));
        stapel.addKarte(new Karte("Karo", "Zehn"));
        stapel.addKarte(new Karte("Karo", "Bube"));
        stapel.addKarte(new Karte("Karo", "Dame"));
        stapel.addKarte(new Karte("Karo", "König"));
        stapel.addKarte(new Karte("Karo", "Ass"));
    }
}