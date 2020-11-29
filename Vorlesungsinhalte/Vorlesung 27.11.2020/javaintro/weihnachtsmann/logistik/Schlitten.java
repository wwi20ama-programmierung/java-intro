package javaintro.weihnachtsmann.logistik;

import javaintro.weihnachtsmann.lebewesen.Elf;
import javaintro.weihnachtsmann.lebewesen.Rentier;

public class Schlitten {
    private Elf fahrer;
    private Rentier[] rentiere = new Rentier[6]; // Wir nutzen hier ein "normales" Array, da immer genau 6 Rentiere benötigt werden.
    private Lieferliste lieferliste;

    private final static int MAXIMALGEWICHT = 100;

    // Wenn wir noch keine Rentiere einspannen möchten, können wir erst einmal einen Schlitten nur mit Fahrer ohne Rentiere initialisieren ...
    public Schlitten(Elf fahrer, Lieferliste lieferliste) {
        this.fahrer = fahrer;
        this.lieferliste = lieferliste;
    }

    // ... oder wir geben (alle 6) Rentiere direkt bei der Initialisierung eines Schlittens mit (-> siehe statische Polymorphie)
    public Schlitten(Elf fahrer, Rentier[] rentiere, Lieferliste lieferliste) {
        this(fahrer, lieferliste); // wir rufen den anderen Konstruktor (mit weniger Parametern) auf -> doppelten Code vermeiden

        // Es müssen alle sechs Rentiere übergeben werden:
        if (rentiere.length < 6) {
            System.out.println("Der Schlitten ist noch nicht bereit - es wurden nur " + rentiere.length + " Rentiere eingespannt!");
        } else {
            this.rentiere = rentiere;
        }
    }

    public void addRentier(Rentier rentier) {
        for (int i = 0; i < this.rentiere.length; i++) {
            if (this.rentiere[i] == null) { // Ist Index in Array noch frei?
                this.rentiere[i] = rentier;
                return; // Wir können hier abbrechen
            }
        }
        // Falls kein Platz mehr frei war (d.h. die Methode noch nicht durch "return" beendet wurde):
        System.out.println("Es sind bereits alle sechs Rentiere eingespannt!");
    }

    public void fliegen() {
        if (this.rentiere.length < 6) {
            System.out.println("Es sind nur " + this.rentiere.length + " von 6 Rentieren eingespannt. Der Schlitten kann nicht abheben!");
            return;
        }

        if (this.lieferliste.getGesamtgewicht() > MAXIMALGEWICHT) {
            System.out.println("Der Schlitten ist mit " + this.lieferliste.getGesamtgewicht() + " kg zu schwer und kann nicht abheben!");
            return;
        }

        // Falls die Methode noch nicht beendet wurde ("return"), muss sich jedes Rentier bewegen, damit der Schlitten fliegen kann:
        for (int i = 0; i < rentiere.length; i++) { // kein ".size()" sondern ".length", da wir ein Array statt einer ArrayList verweden
            Rentier rentierAmIndex = rentiere[i];
            rentierAmIndex.bewegen();
        }
    }
}