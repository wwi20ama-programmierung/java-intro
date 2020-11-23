package javaintro.maumau.ki;

import java.util.ArrayList;

// Der KI-Spieler erbt alle Attribute und Methoden vom "normalen" (menschlichen) Spieler
public class KI extends Spieler {

    // Konstruktor
    public KI(String name) {
        super(name); // wir rufen den Konstruktor der Elternklasse ("Spieler") auf
        this.isKI = true;
        System.out.println(this.name);
    }

    // Wir ergänzen die KI-Klasse mit einer weiteren Methode (im Vergleich zur Elternklasse "Spieler")
    public String getNextAction(Karte obereKarte) {
        // ermitteln, welche Züge der Computerspieler durchführen kann

        // Überprüfe alle Karten auf der Hand
        ArrayList<Karte> verfuegbareKarten = this.getHand().getKarten();
        for (int i = 0; i < verfuegbareKarten.size(); i++) {
            Karte karte = verfuegbareKarten.get(i);

            if (karte.pruefe(obereKarte)) {
                // falls passende Karte vorhanden: legen
                System.out.println(this.name + " (KI) wählt Karte " + (i + 1) + " (" + karte.getSymbol() + " " + karte.getWert() + ") aus.");

                // Hier müssen wir die Methode über "return" abbrechen, ansonsten läuft sie immer bis zum "ziehen" weiter!
                return Integer.toString(i + 1); // oder: String.valueOf(i);
            }
        }

        // ansonsten: ziehen
        System.out.println(this.name + " (KI) zieht eine neue Karte vom Kartenstapel.");
        return "z";
    }
}