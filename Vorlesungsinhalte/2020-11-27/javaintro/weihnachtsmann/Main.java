package javaintro.weihnachtsmann;

import javaintro.weihnachtsmann.geschenke.Geschenk;
import javaintro.weihnachtsmann.geschenke.Wunsch;
import javaintro.weihnachtsmann.lebewesen.Elf;
import javaintro.weihnachtsmann.lebewesen.Kind;
import javaintro.weihnachtsmann.geschenke.Auto;
import javaintro.weihnachtsmann.lebewesen.Rentier;
import javaintro.weihnachtsmann.lebewesen.Weihnachtsmann;
import javaintro.weihnachtsmann.logistik.Lieferliste;
import javaintro.weihnachtsmann.logistik.Paket;
import javaintro.weihnachtsmann.logistik.Schlitten;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        // Weihnachtsmann intialisieren
        Weihnachtsmann weihnachtsmann = new Weihnachtsmann();

        // Elfen initialisieren
        Elf lena = new Elf("Lena");
        Elf ralf = new Elf("Ralf");

        // Rentiere initialisieren
        Rentier[] rentiere = new Rentier[6]; // Unser Schlitten kann nur von genau 6 Rentieren gezogen werden
        rentiere[0] = new Rentier("Rudolph");
        rentiere[1] = new Rentier("Dasher");
        rentiere[2] = new Rentier("Dancer");
        rentiere[3] = new Rentier("Donner");
        rentiere[4] = new Rentier("Blitzen");
        rentiere[5] = new Rentier("Cupid");

        // Schlitten initialisieren
        Schlitten schlitten = new Schlitten(lena, rentiere);

        // Kinder initialisieren
        Kind lisa = new Kind("Lisa", true, "Hauptstraße 21, 12345 Musterstadt", 'w');
        Kind max = new Kind("Max", false, "Hauptstraße 21, 12345 Musterstadt", 'm');
        Kind anna = new Kind("Anna", false, "Schlossstraße 123, 12345 Musterstadt", 'w');
        Kind moritz = new Kind("Moritz", true, "Nebengasse 42, 12345 Musterstadt", 'm');

        // Wünsche initialisieren
        lisa.wuenschen("Tolle Sportschuhe", "Schuh");
        max.wuenschen("Blaues ferngesteuertes Auto", "Auto");
        anna.wuenschen("Schach", "Spiel");
        moritz.wuenschen("Roter Kettcar", "Auto");
        moritz.wuenschen("Kopfhörer für das Handy", "Elektronik"); // -> wird ein "Standard-Geschenk", da wir keine Spezialisierungsklasse für "Elektronik" definiert haben

        // Die Kinder senden ihre Wünsche an den Weihnachtsmann
        lisa.wunschlisteSenden(weihnachtsmann);
        max.wunschlisteSenden(weihnachtsmann);
        anna.wunschlisteSenden(weihnachtsmann);
        moritz.wunschlisteSenden(weihnachtsmann);

        Lieferliste lieferliste = new Lieferliste();

        for (Wunsch wunsch : weihnachtsmann.getAlleWuensche()) {
            // // Der Weihnachtsmann verzaubert die Geschenke...
            Geschenk geschenk = weihnachtsmann.verzaubern(wunsch);
            // ... die Elfen (bzw. Ralf) verpacken sie sofort ...
            Paket paket = ralf.verpacken(geschenk);
            // ... erstellen eine Lieferliste ...
            lieferliste.addPaket(paket);
        }

        // ... und laden die Pakete auf den Schlitten.
        schlitten.setLieferliste(lieferliste);

        System.out.println("Die Rentiere müssen " + lieferliste.getGesamtgewicht() + " kg ziehen!");

        System.out.println(); // Abstandshalter

        schlitten.fliegen();
        schlitten.fliegen();
        schlitten.fliegen();
        schlitten.fliegen();
        schlitten.fliegen(); // Die Rentiere brauchen eine Pause!

        // Lena füttert alle Rentiere
        for (int i = 0; i < rentiere.length; i++) {
            lena.fuettern(rentiere[i]);
        }

        System.out.println(); // Abstandshalter

        schlitten.fliegen(); // ... und weitere geht's!
    }
}